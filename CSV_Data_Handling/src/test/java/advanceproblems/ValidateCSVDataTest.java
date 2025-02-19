package advanceproblems;

import com.ioprogramming.advanceprogramming.ValidateCSVData;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateCSVDataTest {

    private static final String TEST_FILE = "test_employees.csv";

    @BeforeAll
    static void setup() throws IOException {
        // Create a test CSV file with valid and invalid data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write("ID,Name,Department,Email,Phone\n");
            writer.write("1,John Doe,HR,john.doe@example.com,9876543210\n");   // Valid
            writer.write("2,Jane Smith,IT,jane.smith@company,12345\n");        // Invalid Email & Phone
            writer.write("3,Emily Davis,Finance,emily.davis@gmail.com,9998887776\n");  // Valid
            writer.write("4,Michael Brown,IT,michael@.com,abcdefghij\n");      // Invalid Email & Phone
            writer.write("5,David Wilson,Marketing,david.wilson@xyz.com,1234567890\n"); // Valid
        }
    }

    @AfterAll
    static void cleanup() {
        // Delete the test file after execution
        new File(TEST_FILE).delete();
    }

    @Test
    void testValidateCSV() throws IOException {
        // Redirect output to a stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call the validation method
        ValidateCSVData.validateCSV(TEST_FILE);

        // Restore original output stream
        System.setOut(originalOut);

        // Capture output as a list of lines
        List<String> outputLines = Arrays.asList(outputStream.toString().split("\n"));

        // Verify error messages
        assertTrue(outputLines.stream().anyMatch(line -> line.contains("ERROR: Invalid record: 2,Jane Smith,IT,jane.smith@company,12345")));
        assertTrue(outputLines.stream().anyMatch(line -> line.contains("ERROR: Invalid Email: jane.smith@company")));
        assertTrue(outputLines.stream().anyMatch(line -> line.contains("ERROR: Invalid Phone: 12345")));

        assertTrue(outputLines.stream().anyMatch(line -> line.contains("ERROR: Invalid record: 4,Michael Brown,IT,michael@.com,abcdefghij")));
        assertTrue(outputLines.stream().anyMatch(line -> line.contains("ERROR: Invalid Email: michael@.com")));
        assertTrue(outputLines.stream().anyMatch(line -> line.contains("ERROR: Invalid Phone: abcdefghij")));
    }
}
