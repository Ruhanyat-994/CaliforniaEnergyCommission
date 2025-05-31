package FirstTestSuit.Assertions.CF2RMCH01BE;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CF2RMCH01BE_Assertions {

    public static void errorHandling(Runnable assertCatch, String description) {
        try {
            assertCatch.run();
            System.out.println("✅ " + description);
        } catch (AssertionError error) {
            System.out.println("❌ " + description + ": " + error.getMessage());
        }
    }

    public static void runAssertions(Page page1) throws InterruptedException {
        Locator unitName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Unit Name..."));
        errorHandling(() -> {
            assertThat(unitName).hasValue("Florida 2");
        }, "'Unit Name' field has 'Florida 2'");

        Locator conditionedArea = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Conditioned Floor Area"));
        errorHandling(() -> {
            assertThat(conditionedArea).hasValue("3000");
        }, "'Conditioned Floor Area' field has '3000'");

        Locator numSystems = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of Space Conditioning"));
        errorHandling(() -> {
            assertThat(numSystems).hasValue("1");
        }, "'# of Space Conditioning' field has '1'");

        Locator bedrooms = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of bedrooms..."));
        errorHandling(() -> {
            assertThat(bedrooms).hasValue("5");
        }, "'# of bedrooms' field has '5'");



// --- Add scrolling and waiting before next input field ---
        Locator systemName = page1.locator("input[name=\"residentialSpaceConditioningSystemName\"]");

// Wait for the element to be attached to the DOM and visible
        systemName.waitFor(new Locator.WaitForOptions().setTimeout(5000));

// Scroll the element into view using JavaScript
        systemName.evaluate("el => el.scrollIntoView({behavior: 'smooth', block: 'center'})");

// Small delay to ensure the page settles after scrolling
        Thread.sleep(500);

        errorHandling(() -> {
            systemName.fill("System 1");
            assertThat(systemName).hasValue("System 1");
        }, "'System Name' has 'System 1'");

        Locator systemArea = page1.locator("input[name=\"residentialHvacSystemAreaServed\"]");
        errorHandling(() -> {
            systemArea.fill("Location 1");
            assertThat(systemArea).hasValue("Location 1");
        }, "'System Area Served' has 'Location 1'");


//        Locator systemName = page1.locator("input[name=\"residentialSpaceConditioningSystemName\"]");
//        errorHandling(() -> {
//            systemName.fill("System 1");
//            assertThat(systemName).hasValue("System 1");
//        }, "'System Name' has 'System 1'");
//
//        Locator systemArea = page1.locator("input[name=\"residentialHvacSystemAreaServed\"]");
//        errorHandling(() -> {
//            systemArea.fill("Location 1");
//            assertThat(systemArea).hasValue("Location 1");
//        }, "'System Area Served' has 'Location 1'");

        Locator squareFeet = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Square feet..."));
        errorHandling(() -> {
            assertThat(squareFeet).hasValue("3000");
        }, "'Square Feet' field has '3000'");

        Locator numUnits = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of units..."));
        errorHandling(() -> {
            assertThat(numUnits).hasValue("1");
        }, "'# of units' field has '1'");

        Locator manufacturer = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Manufacturer..."));
        errorHandling(() -> {
            assertThat(manufacturer).hasValue("John Smith");
        }, "'Manufacturer' field has 'John Smith'");

        Locator modelNumber = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Model Number..."));
        errorHandling(() -> {
            assertThat(modelNumber).hasValue("11111");
        }, "'Model Number' field has '11111'");

        Locator serialNumber = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Serial Number..."));
        errorHandling(() -> {
            assertThat(serialNumber).hasValue("151");
        }, "'Serial Number' field has '151'");

        Locator outputBTU = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Output (Btu/h)"));
        errorHandling(() -> {
            assertThat(outputBTU).hasValue("5000");
        }, "'Output (Btu/h)' field has '5000'");

        // Optional: Add sleep to observe the browser before closing
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Finished all assertions for CF2RMCH01BE.");
    }
}
