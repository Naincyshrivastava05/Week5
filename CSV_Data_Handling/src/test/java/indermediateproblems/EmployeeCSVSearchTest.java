package indermediateproblems;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeCSVSearchTest {

    private static final String TEST_FILE = "src\\main\\resources\\test_employees.csv";

    @BeforeAll
    static void setup() throws IOException {
        // Create a test CSV file with sample employee data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("1,Naincy,HR,50000\n");
            writer.write("2,Sanjh,IT,65000\n");
            writer.write("3,Vaishali,Finance,70000\n");
            writer.write("4,Vishakha,Marketing,60000\n");
            writer.write("5,Raksha,IT,75000\n");
        }
    }


    @Test
    void testSearchEmployeeByName() {
        Optional<String> result = searchEmployeeByName(TEST_FILE, "Jane Smith");
        assertTrue(result.isPresent(), "Employee should be found");
        assertEquals("IT,65000", result.get(), "Department and salary should match");
    }

    @Test
    void testSearchNonExistentEmployee() {
        Optional<String> result = searchEmployeeByName(TEST_FILE, "Alice Johnson");
        assertFalse(result.isPresent(), "Employee should not be found");
    }

    // Method to search for an employee by name in the CSV file
    private Optional<String> searchEmployeeByName(String filePath, String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip header row
                }
                String[] data = line.split(",");
                if (data.length == 4 && data[1].trim().equalsIgnoreCase(name)) {
                    return Optional.of(data[2] + "," + data[3]); // Department, Salary
                }
            }
        } catch (IOException e) {
            fail("Error reading the CSV file: " + e.getMessage());
        }
        return Optional.empty();
    }
}
