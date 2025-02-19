package advanceproblems;
import com.ioprogramming.advanceprogramming.CSVDataintoJavaObjects.ConvertCSVToObjects;
import com.ioprogramming.advanceprogramming.CSVDataintoJavaObjects.Students;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ConvertCSVToObjectsTest {

    private static final String TEST_FILE = "test_students.csv";

    @BeforeAll
    static void setup() throws IOException {
        // Create a test CSV file with student data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write("ID,Name,Age,Marks\n");
            writer.write("1,Alice,20,85.5\n");
            writer.write("2,Bob,22,78.0\n");
            writer.write("3,Charlie,21,92.3\n");
            writer.write("4,David,23,74.5\n");
            writer.write("5,Eve,19,88.9\n");
        }
    }

    @AfterAll
    static void cleanup() {
        // Delete the test file after execution
        new File(TEST_FILE).delete();
    }

    @Test
    void testReadStudentsFromCSV() {
        // Read students from CSV
        List<Students> students = ConvertCSVToObjects.readStudentsFromCSV(TEST_FILE);

        // Verify the number of students read
        assertEquals(5, students.size());

        // Verify first student details
        Students firstStudent = students.get(0);
    }
}