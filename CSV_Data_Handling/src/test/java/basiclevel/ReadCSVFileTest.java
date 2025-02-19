package basiclevel;

import com.ioprogramming.basicproblems.ReadCSVFile;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class ReadCSVFileTest {
    private static final String TEST_CSV_FILE = "src\\main\\resources\\Student.csv";


    @Test
    void testReadCSV() {
        assertDoesNotThrow(() -> ReadCSVFile.readCSV(TEST_CSV_FILE));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }
}

