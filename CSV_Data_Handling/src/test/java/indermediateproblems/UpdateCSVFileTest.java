package indermediateproblems;

import com.ioprogramming.intermediateproblems.UpdateCSVFile;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateCSVFileTest {

    private static final String TEST_INPUT_FILE = "src\\main\\resources\\employees.csv";
    private static final String TEST_OUTPUT_FILE = "src\\main\\resources\\test_updated_employees.csv";

    @BeforeAll
    static void setup() throws IOException {
        // Create a test CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_INPUT_FILE))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("1,Naincy,HR,50000\n");
            writer.write("2,Sanjh,IT,65000\n");
            writer.write("3,Vishakha,Finance,70000\n");
            writer.write("4,Raksha,IT,60000\n");
            writer.write("5,Vaishali,Marketing,55000\n");
        }
    }



    @Test
    void testUpdateSalaries() throws IOException {
        UpdateCSVFile.updateSalaries(TEST_INPUT_FILE, TEST_OUTPUT_FILE);

        // Read the updated file
        List<String> lines = Files.readAllLines(Paths.get(TEST_OUTPUT_FILE));
        assertEquals(6, lines.size(), "File should contain a header and 5 records.");

        // Check the updated values
        assertTrue(lines.get(1).contains("HR,50000"), "HR salary should not change.");
        assertTrue(lines.get(2).contains("IT,71500.00"), "IT salary should be increased by 10%.");
        assertTrue(lines.get(3).contains("Finance,70000"), "Finance salary should not change.");
        assertTrue(lines.get(4).contains("IT,66000.00"), "IT salary should be increased by 10%.");
        assertTrue(lines.get(5).contains("Marketing,55000"), "Marketing salary should not change.");
    }
}

