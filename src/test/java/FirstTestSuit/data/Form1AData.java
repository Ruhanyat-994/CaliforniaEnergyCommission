package FirstTestSuit.data;


import java.util.HashMap;
import java.util.Map;

public class Form1AData {
    public static Map<String, String> getValidData() {
        Map<String, String> data = new HashMap<>();
        data.put("projectName", "Test Project 001");
        data.put("address", "123 Test Lane");
        data.put("zip", "90210");
        // Add all required fields here
        return data;
    }
}
