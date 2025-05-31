package FirstTestSuit.Assertions.CF1RALT02E;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CF1RALT02E_Assertions {

    public static void errorHandling(Runnable assertCatch, String description) {
        try {
            assertCatch.run();
            System.out.println("✅ " + description);
        } catch (AssertionError error) {
            System.out.println("❌ " + description + ": " + error.getMessage());
        }
    }

    public static void runAssertions(Page page1) {
        Locator projectInput = page1.locator("input#name");
        errorHandling(() -> {
            assertThat(projectInput).isVisible();
            assertThat(projectInput).hasValue("Testing 1");
        }, "'Project Name' input is present and contains 'Testing 1'");

        Locator street = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street..."));
        errorHandling(() -> {
            assertThat(street).hasValue("Florida");
        }, "'Address' input is present and contains 'Florida'");

        Locator apt = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Apt #, Floor, etc..."));
        errorHandling(() -> {
            assertThat(apt).hasValue("3rd Floor");
        }, "'Apt' field has '3rd Floor'");

        Locator city = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("City..."));
        errorHandling(() -> {
            assertThat(city).hasValue("Florida");
        }, "'City' field has 'Florida'");

        Locator state = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("State..."));
        errorHandling(() -> {
            assertThat(state).hasValue("FL");
        }, "'State' field has 'FL'");

        Locator zip = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Zip..."));
        errorHandling(() -> {
            assertThat(zip).hasValue("33138");
        }, "'Zip' field has '33138'");

        Locator permitDate = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Permit Number Date"));
        errorHandling(() -> {
            assertThat(permitDate).hasValue("TBD");
        }, "'Permit Number Date' field has 'TBD'");

        errorHandling(() -> {
            page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Date...")).click();
            page1.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("20").setExact(true)).click();
        }, "Calendar interaction for date '20'");

        Locator unitName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Unit Name..."));
        errorHandling(() -> {
            assertThat(unitName).hasValue("Testing 1");
        }, "'Unit Name' field has 'Testing 1'");

        Locator conditionedArea = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Conditioned Floor Area"));
        errorHandling(() -> {
            assertThat(conditionedArea).hasValue("2200");
        }, "'Conditioned Floor Area' field has '2200'");

        Locator firstName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Home Owner First Name"));
        errorHandling(() -> {

            assertThat(firstName).hasValue("Olivia");
        }, "'First Name' field has 'Olivia'");

        Locator lastName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"));
        errorHandling(() -> {

            assertThat(lastName).hasValue("Lee");
        }, "'Last Name' field has 'Lee'");

        Locator phone = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone"));
        errorHandling(() -> {
            assertThat(phone).hasValue("(408) 555-7890");
        }, "'Phone' field has '(408) 555-7890'");

        Locator email = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(" Email"));
        errorHandling(() -> {
            assertThat(email).hasValue("olivia@lee.com");
        }, "'Email' field has 'olivia@lee.com'");

        Locator systemName = page1.locator("input[name=\"residentialSpaceConditioningSystemName\"]");
        errorHandling(() -> {

            assertThat(systemName).hasValue("System 1");
        }, "'System Name' has 'System 1'");

        Locator systemArea = page1.locator("input[name=\"residentialHvacSystemAreaServed\"]");
        errorHandling(() -> {
            assertThat(systemArea).hasValue("Location 1");
        }, "'System Area Served' has 'Location 1'");

        Locator squareFeet = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Square feet..."));
        errorHandling(() -> {
            assertThat(squareFeet).hasValue("2200");
        }, "'Square Feet' has '2200'");

        Locator noAlterationCheckbox = page1.getByLabel("No Alteration Performed");
        errorHandling(() -> {
            assertThat(noAlterationCheckbox).isVisible();
            assertThat(noAlterationCheckbox).isChecked();
        }, "'No Alteration Performed' checkbox is visible and checked");

        System.out.println("✅ Finished all assertions.");
    }
}

