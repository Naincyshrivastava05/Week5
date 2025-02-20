package handsonpractiseproblem;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.Reader;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConvertCsvToJsonTest {

    @Test
    public void testCsvToJsonConversion() throws Exception {
        Reader reader = new FileReader("src/main/resources/employees.csv");
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        List<Map<String, String>> csvData = new ArrayList<>();
        for (CSVRecord record : csvParser) {
            Map<String, String> row = new HashMap<>();
            record.toMap().forEach(row::put);
            csvData.add(row);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);

        assertTrue(jsonData.contains("ID"));
        assertTrue(jsonData.contains("Name"));
        assertTrue(jsonData.contains("Department"));
        assertTrue(jsonData.contains("Salary"));

        csvParser.close();
        reader.close();
    }
}