package handsonpractiseproblem;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.*;

import java.io.*;
import java.util.*;

public class ConvertCsvToJson {
    public static void main(String[] args) {
        try {
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

            System.out.println("Converted JSON:\n" + jsonData);

            csvParser.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}