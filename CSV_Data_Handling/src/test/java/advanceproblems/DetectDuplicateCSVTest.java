package advanceproblems;

import com.ioprogramming.advanceprogramming.DetectDuplicateCSV;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class DetectDuplicateCSVTest {

    private static final String TEST_FILE = "src\\main\\resources\\duplicates.csv";

    @BeforeAll
    static void setup() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write("ID,Name,Age\n");
            writer.write("1,Alice,20\n");
            writer.write("2,Bob,22\n");
            writer.write("3,Charlie,21\n");
            writer.write("2,Bob,22\n"); // Duplicate
        }
    }

    @AfterAll
    static void cleanup() {
        new File(TEST_FILE).delete();
    }

    @Test
    void testDetectDuplicates() {
        DetectDuplicateCSV.detectDuplicates(TEST_FILE);
        assertTrue(new File(TEST_FILE).exists());
    }
}
