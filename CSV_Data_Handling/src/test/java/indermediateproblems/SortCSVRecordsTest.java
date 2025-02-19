package indermediateproblems;

import com.ioprogramming.intermediateproblems.SortCSVRecords;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SortCSVRecordsTest {

    private static final String TEST_FILE = "test_employees.csv";

    @BeforeAll
    static void setup() throws IOException {
        // Create a test CSV file with employee data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("1,Naincy,HR,50000\n");
            writer.write("2,Sanjh,IT,65000\n");
            writer.write("3,Vaishali,Finance,70000\n");
            writer.write("4,Palak,IT,60000\n");
            writer.write("5,Raksha,Marketing,55000\n");
            writer.write("6,Vishakha,Sales,72000\n");
            writer.write("7,Dolly,Finance,68000\n");
        }
    }


    @Test
    void testSortEmployeesBySalary() throws IOException {
        // Redirect output to a stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call the sorting method
        SortCSVRecords.sortEmployeesBySalary(TEST_FILE);

        // Restore original output stream
        System.setOut(originalOut);

        // Capture output as a list of lines
        List<String> outputLines = Arrays.asList(outputStream.toString().split("\n"));

        // Verify header
        assertTrue(outputLines.get(0).contains("ID,Name,Department,Salary"));

        // Verify top 5 salaries (highest to lowest)
        assertTrue(outputLines.get(2).contains("Vishakha,Sales,72000"));
        assertTrue(outputLines.get(3).contains("Vaishali,Finance,70000"));
        assertTrue(outputLines.get(4).contains("Dolly,Finance,68000"));
        assertTrue(outputLines.get(5).contains("Sanjh,IT,65000"));
        assertTrue(outputLines.get(6).contains("Palak,IT,60000"));
    }
}
