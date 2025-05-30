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

    public static void runAssertions(Page page1) {
        Locator unitName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Unit Name..."));
        errorHandling(() -> {
            unitName.fill("Florida 2");
            assertThat(unitName).hasValue("Florida 2");
        }, "'Unit Name' field has 'Florida 2'");

        Locator conditionedArea = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Conditioned Floor Area"));
        errorHandling(() -> {
            conditionedArea.fill("3000");
            assertThat(conditionedArea).hasValue("3000");
        }, "'Conditioned Floor Area' field has '3000'");

        Locator numSystems = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of Space Conditioning"));
        errorHandling(() -> {
            numSystems.fill("1");
            assertThat(numSystems).hasValue("1");
        }, "'# of Space Conditioning' field has '1'");

        Locator bedrooms = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of bedrooms..."));
        errorHandling(() -> {
            bedrooms.fill("5");
            assertThat(bedrooms).hasValue("5");
        }, "'# of bedrooms' field has '5'");

        Locator systemName = page1.locator("input[name=\"residentialSpaceConditioningSystemName\"]");
        errorHandling(() -> {
            systemName.fill("System 1");
            assertThat(systemName).hasValue("System 1");
        }, "'System Name' field has 'System 1'");

        Locator systemArea = page1.locator("input[name=\"residentialHvacSystemAreaServed\"]");
        errorHandling(() -> {
            systemArea.fill("Location 1");
            assertThat(systemArea).hasValue("Location 1");
        }, "'System Area Served' field has 'Location 1'");

        Locator squareFeet = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Square feet..."));
        errorHandling(() -> {
            squareFeet.fill("3000");
            assertThat(squareFeet).hasValue("3000");
        }, "'Square Feet' field has '3000'");

        // Optional: Add sleep at the end (e.g., to observe changes manually before browser closes)
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Finished all assertions for CF2RMCH01BE.");
    }
}
