package handsonpractiseproblem;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.sql.*;

public class GenerateJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/company_db?useSSL=false";
        String user = "Abhi";
        String password = "Abhi@123";

        String query = "SELECT emp_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            while (rs.next()) {
                ObjectNode record = objectMapper.createObjectNode();
                record.put("emp_id", rs.getInt("emp_id"));
                record.put("name", rs.getString("name"));
                record.put("department", rs.getString("department"));
                record.put("salary", rs.getInt("salary"));
                jsonArray.add(record);
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/report.json"), jsonArray);

            System.out.println("JSON report generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}