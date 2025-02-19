package advanceproblems;

import com.ioprogramming.advanceprogramming.DatabaseToCSV;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseToCSVTest {
    private static final String TEST_FILE = "test_employees.csv";

    @Test
    void testWriteEmployeesToCSV() {
        DatabaseToCSV.writeEmployeesToCSV("jdbc:mysql://localhost:3306/company", "root", "password", TEST_FILE);
        assertTrue(new File(TEST_FILE).exists());
    }
}
