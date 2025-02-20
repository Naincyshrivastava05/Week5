package handsonpractiseproblem;

package com.handsonpracticeproblems.json;
import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class IPLDataCensorTest {

    String jsonInputFile = "src/main/resources/ipl.json";
    String jsonOutputFile = "src/main/resources/censored_ipl.json";
    String csvInputFile = "src/main/resources/ipl.csv";
    String csvOutputFile = "src/main/resources/censored_ipl.csv";

    @Test
    void testJsonOutputFileIsNotEmpty() throws Exception {
        IPLDataCensor.processJsonFile(jsonInputFile, jsonOutputFile);
        File outputFile = new File(jsonOutputFile);
        assertTrue(outputFile.exists() && outputFile.length() > 0);
    }

    @Test
    void testCsvOutputFileIsNotEmpty() throws Exception {
        IPLDataCensor.processCsvFile(csvInputFile, csvOutputFile);
        File outputFile = new File(csvOutputFile);
        assertTrue(outputFile.exists() && outputFile.length() > 0);
    }
}