package indermediateproblems;

import com.ioprogramming.intermediateproblems.FilterCSVRecords;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FilterCSVRecordsTest {
    private static final String TEST_CSV_FILE = "src\\main\\resources\\test_students.csv";
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() throws IOException {
        String testData = "ID,Name,Age,Marks\n"
                + "101,Naincy,20,85\n"
                + "102,Sanjh,22,90\n"
                + "103,Vaishali,19,78\n"
                + "104,Vishakha,21,88\n"
                + "105,Raksha,23,60\n";
        Files.write(Paths.get(TEST_CSV_FILE), testData.getBytes());
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testFilterHighScorers() {
        FilterCSVRecords.filterHighScorers(TEST_CSV_FILE);
        String output = outputStream.toString().trim();
        assertTrue(output.contains("101 | Naincy | 20 | 85"));
        assertTrue(output.contains("102 | Sanjh | 22 | 90"));
        assertTrue(output.contains("104 | Vishakha | 21 | 88"));
        assertFalse(output.contains("103 | Vaishali | 19 | 78"));
        assertFalse(output.contains("105 | Raksha | 23 | 60"));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
        System.setOut(originalOut);
    }
}
