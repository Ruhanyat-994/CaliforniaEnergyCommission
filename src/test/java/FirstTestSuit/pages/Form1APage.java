package FirstTestSuit.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Map;

public class Form1APage {
    private final Page page;

    public Form1APage(Page page) {
        this.page = page;
    }

    public void fillForm(Map<String, String> data) {
        page.locator("#name").fill(data.get("projectName"));
        page.locator("#A03_StreetAddress").fill(data.get("address"));
        page.locator("#city").fill(data.get("city"));
        page.locator("#state").fill(data.get("state"));
        page.locator("#zip").fill(data.get("zip"));
        page.locator("#permitNumber").fill(data.get("permitNumber"));
        page.locator("input[name='permitDate']").fill(data.get("permitDate"));

//        // Clear tags input — may require 'Backspace' if it's a chips/tag input
//        page.locator("input[placeholder='Search for Building Department']").click();
//        page.keyboard().press("Control+A"); // Select all
//        page.keyboard().press("Backspace"); // Clear
//        page.fill("placeholder=Select department or type in", data.get("buildingDepartment"));
//        page.keyboard().press("Enter");
//
//        // Dropdowns
//        page.selectOption("name=ahjIdHash", data.get("ahj"));
//        page.selectOption("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[1]/" +
//                "div[2]/div[1]/form/div[6]/div/select/option[3]", data.get("buildingType"));
//
//        // Other fields
//        page.locator("input[name='dwellingUnitName']").fill(data.get("dwellingUnitName"));
//        page.locator("input[name='conditionedFloorArea']").fill(data.get("conditionedFloorArea"));
//        page.locator("input[name='numSCSystems']").fill(data.get("numSCSystems"));
//        page.locator("input[name='numBedrooms']").fill(data.get("numBedrooms"));
//        Locator climateZone = page.locator("climateZone");
//        climateZone.selectOption("9");
//
//
//
//        page.locator("input[name='homeOwnerFirstName']").fill(data.get("homeOwnerFirstName"));
//        page.locator("input[name='homeOwnerLastName']").fill(data.get("homeOwnerLastName"));
//        page.locator("input[name='homeOwnerPhone']").fill(data.get("homeOwnerPhone"));
//        page.locator("input[name='homeOwnerEmail']").fill(data.get("homeOwnerEmail"));
    }

// ---------------------------------------------------------------------------------------------
//    public void submitForm() {
//        page.click("text=Update Project");
//    }
}
