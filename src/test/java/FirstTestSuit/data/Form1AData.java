package FirstTestSuit.data;


import java.util.HashMap;
import java.util.Map;

public class Form1AData {
    public static Map<String, String> getValidData() {
        Map<String, String> data = new HashMap<>();
        data.put("projectName", "Line F 102824");
        data.put("address", "344 Sandy Cove Dr");
        data.put("city", "Chico");
        data.put("state", "CA");
        data.put("zip", "95973");
        data.put("permitNumber", "TBD");
        data.put("permitDate", "2024-10-30");
        data.put("buildingDepartment", "Butte County");
        data.put("ahj", "Local Building Department"); // replace with real option
        data.put("buildingType", "Single-Family");
        data.put("dwellingUnitName", "Line H 102824");
        data.put("conditionedFloorArea", "1862");
        data.put("numSCSystems", "1");
        data.put("numBedrooms", "3");
        data.put("climateZone", "9");
        data.put("homeOwnerFirstName", "Jane");
        data.put("homeOwnerLastName", "Smith");
        data.put("homeOwnerPhone", "222-222-5555");
        data.put("homeOwnerEmail", "test@test.com");
        return data;
    }
}
