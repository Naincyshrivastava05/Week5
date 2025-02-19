package advanceproblems;

import com.ioprogramming.advanceprogramming.JSONCSVConverter;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class JSONCSVConverterTest {
    private static final String JSON_FILE = "test_students.json";
    private static final String CSV_FILE = "test_students.csv";

    @BeforeAll
    static void setup() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE))) {
            writer.write("[{\"ID\":1,\"Name\":\"Naincy\",\"Age\":20,\"Marks\":85}," +
                    "{\"ID\":2,\"Name\":\"Sanjh\",\"Age\":22,\"Marks\":78}]");
        }
    }

    @AfterAll
    static void cleanup() {
        new File(JSON_FILE).delete();
        new File(CSV_FILE).delete();
    }

    @Test
    void testConvertJSONToCSV() {
        JSONCSVConverter.convertJSONToCSV(JSON_FILE, CSV_FILE);
        assertTrue(new File(CSV_FILE).exists());
    }
}
