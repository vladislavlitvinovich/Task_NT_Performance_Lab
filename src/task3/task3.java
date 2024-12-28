package task3;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


public class task3 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type rootType = new TypeToken<Map<String, List<Map<String, Object>>>>() {
        }.getType();
        Type valuesType = new TypeToken<Map<String, List<Map<String, Object>>>>() {
        }.getType();
        try (FileReader testsReader = new FileReader("src/task3/tests.json");
             FileReader valuesReader = new FileReader("src/task3/values.json")) {
            Map<String, List<Map<String, Object>>> root = gson.fromJson(testsReader, rootType);
            List<Map<String, Object>> tests = root.get("tests");
            Map<String, List<Map<String, Object>>> valuesRoot = gson.fromJson(valuesReader, valuesType);
            List<Map<String, Object>> values = valuesRoot.get("values");
            updateValues(tests, values);
            try (FileWriter writer = new FileWriter("src/task3/report.json")) {
                gson.toJson(root, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateValues(List<Map<String, Object>> nodes, List<Map<String, Object>> values) {
        for (Map<String, Object> node : nodes) {
            if (node.containsKey("values")) {
                updateValues((List<Map<String, Object>>) node.get("values"), values);
            }
            for (Map<String, Object> value : values) {
                if (node.get("id").equals(value.get("id"))) {
                    node.put("value", value.get("value"));
                }
            }
        }
    }
}
