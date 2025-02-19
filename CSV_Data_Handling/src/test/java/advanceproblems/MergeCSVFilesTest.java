package advanceproblems;

import com.ioprogramming.advanceprogramming.CSVDataintoJavaObjects.MergeCSVFiles;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class MergeCSVFilesTest {

    private static final String TEST_FILE_1 = "src\\main\\resources\\students1.csv";
    private static final String TEST_FILE_2 = "src\\main\\resources\\students2.csv";
    private static final String OUTPUT_FILE = "test_merged_students.csv";

    @BeforeAll
    static void setup() throws IOException {
        // Create test_students1.csv (ID, Name, Age)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_1))) {
            writer.write("ID,Name,Age\n");
            writer.write("1,Alice,20\n");
            writer.write("2,Bob,22\n");
            writer.write("3,Charlie,21\n");
            writer.write("4,David,23\n");
            writer.write("5,Eve,19\n");
        }

        // Create test_students2.csv (ID, Marks, Grade)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_2))) {
            writer.write("ID,Marks,Grade\n");
            writer.write("1,85,A\n");
            writer.write("2,78,B\n");
            writer.write("3,92,A\n");
            writer.write("4,74,C\n");
            writer.write("5,88,A\n");
        }
    }
    
    @Test
    void testMergeCSVFiles() throws IOException {
        // Call the merging function
        MergeCSVFiles.mergeCSVFiles(TEST_FILE_1, TEST_FILE_2, OUTPUT_FILE);

        // Read merged file
        List<String> outputLines = Files.readAllLines(Paths.get(OUTPUT_FILE));

        // Check the number of lines (Header + 5 records)
        assertEquals(6, outputLines.size());

        // Verify the header
        assertEquals("ID,Name,Age,Marks,Grade", outputLines.get(0));

        // Verify merged data
        assertEquals("1,Alice,20,85,A", outputLines.get(1));
        assertEquals("2,Bob,22,78,B", outputLines.get(2));
        assertEquals("3,Charlie,21,92,A", outputLines.get(3));
        assertEquals("4,David,23,74,C", outputLines.get(4));
        assertEquals("5,Eve,19,88,A", outputLines.get(5));
    }
}
