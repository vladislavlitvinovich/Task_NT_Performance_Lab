import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Путь к вашему JSON файлу
            File jsonFile = new File("src/task3/tests.json");

            // Чтение JSON файла в строку
            JsonNode jsonString = objectMapper.readTree(jsonFile);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
