package basiclevel;

import com.ioprogramming.basicproblems.WriteCSVFile;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class WriteCSVFileTest {
    private static final String TEST_CSV_FILE = "test_employees.csv";

    @BeforeEach
    void setUp() {
        WriteCSVFile.writeCSV(TEST_CSV_FILE);
    }

    @Test
    void testWriteCSV() {
        File file = new File(TEST_CSV_FILE);
        assertTrue(file.exists(), "CSV file should be created");

        try (BufferedReader br = new BufferedReader(new FileReader(TEST_CSV_FILE))) {
            long lineCount = br.lines().count();
            assertEquals(5, lineCount, "CSV file should contain 5 records");
        } catch (IOException e) {
            fail("Error reading the test CSV file: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }
}
