package handsonpractiseproblem;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class IPLDataCensor {

    public static void main(String[] args) {
        String jsonInputFile = "src/main/resources/ipl.json";
        String jsonOutputFile = "src/main/resources/censored_ipl_data.json";
        String csvInputFile = "src/main/resources/ipl.csv";
        String csvOutputFile = "src/main/resources/censored_ipl_data.csv";

        try {
            processJsonFile(jsonInputFile, jsonOutputFile);
            System.out.println("Censored JSON file generated successfully!");

            processCsvFile(csvInputFile, csvOutputFile);
            System.out.println("Censored CSV file generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void processJsonFile(String inputFile, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = (ArrayNode) objectMapper.readTree(new File(inputFile));

        for (JsonNode match : jsonArray) {
            ((ObjectNode) match).put("team1", censorTeamName(match.get("team1").asText()));
            ((ObjectNode) match).put("team2", censorTeamName(match.get("team2").asText()));
            ((ObjectNode) match).put("winner", censorTeamName(match.get("winner").asText()));
            ((ObjectNode) match).put("player_of_match", "REDACTED");

            ObjectNode scoreNode = (ObjectNode) match.get("score");
            ObjectNode newScoreNode = objectMapper.createObjectNode();

            scoreNode.fields().forEachRemaining(entry -> {
                newScoreNode.put(censorTeamName(entry.getKey()), entry.getValue().asInt());
            });

            ((ObjectNode) match).set("score", newScoreNode);
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), jsonArray);
    }

    public static void processCsvFile(String inputFile, String outputFile) throws IOException {
        try (CSVReader csvReader = new CSVReader(new FileReader(inputFile));
             CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> allData;
            try {
                allData = csvReader.readAll();
            } catch (com.opencsv.exceptions.CsvException e) {
                throw new IOException("Error reading CSV file: " + e.getMessage(), e);
            }

            for (int i = 1; i < allData.size()-1; i++) {
                String[] row = allData.get(i);


                if (i > 0) {
                    row[1] = censorTeamName(row[1]);
                    row[2] = censorTeamName(row[2]);
                    row[5] = censorTeamName(row[5]);
                    row[6] = "REDACTED";
                }

                csvWriter.writeNext(row);
            }
        } catch (IOException e) {
            throw new IOException("Error processing CSV file: " + e.getMessage(), e);
        }
    }


    public static String censorTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
        }
        return String.join(" ", words);
    }
}
