package basiclevel;

import com.ioprogramming.basicproblems.CountCSVRows;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class CountCSVRowsTest {
    private static final String TEST_CSV_FILE = "src\\main\\resources\\test_employees.csv";

    @BeforeEach
    void setUp() throws IOException {
        String testData = "ID,Name,Department,Salary\n"
                + "101,John Doe,IT,60000\n"
                + "102,Jane Smith,HR,55000\n"
                + "103,Emily Davis,Finance,58000\n"
                + "104,Michael Brown,Marketing,62000\n"
                + "105,David Wilson,Sales,59000\n";
        Files.write(Paths.get(TEST_CSV_FILE), testData.getBytes());
    }

    @Test
    void testCountCSVRows() {
        int rowCount = CountCSVRows.countCSVRows(TEST_CSV_FILE);
        assertEquals(5, rowCount, "CSV file should contain 5 records");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }
}