package advanceproblems;

import com.ioprogramming.advanceprogramming.ReadLargeCSV;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReadLargeCSVTest {

    private static final String TEST_FILE = "test_large_data.csv";

    @BeforeAll
    static void setup() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write("ID,Name,Age\n");
            for (int i = 1; i <= 1000; i++) {
                writer.write(i + ",Student" + i + "," + (18 + (i % 5)) + "\n");
            }
        }
    }

    @AfterAll
    static void cleanup() {
        new File(TEST_FILE).delete();
    }

    @Test
    void testReadCSVInChunks() {
        ReadLargeCSV.readCSVInChunks(TEST_FILE, 100);
        assertTrue(new File(TEST_FILE).exists());
    }
}
