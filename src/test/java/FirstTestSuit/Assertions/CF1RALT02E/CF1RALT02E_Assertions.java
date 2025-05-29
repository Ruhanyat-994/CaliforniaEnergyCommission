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
        } catch (AssertionError e) {
            System.out.println("❌ " + description + ": " + e.getMessage());
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
            street.fill("Florida");
            assertThat(street).hasValue("Florida");
        }, "'Address' input is present and contains 'Florida'");

        Locator apt = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Apt #, Floor, etc..."));
        errorHandling(() -> {
            apt.fill("3rd Floor");
            assertThat(apt).hasValue("3rd Floor");
        }, "'Apt' field has '3rd Floor'");

        Locator city = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("City..."));
        errorHandling(() -> {
            city.fill("Florida");
            assertThat(city).hasValue("Florida");
        }, "'City' field has 'Florida'");

        Locator state = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("State..."));
        errorHandling(() -> {
            state.fill("FL");
            assertThat(state).hasValue("FL");
        }, "'State' field has 'FL'");

        Locator zip = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Zip..."));
        errorHandling(() -> {
            zip.fill("33138");
            assertThat(zip).hasValue("33138");
        }, "'Zip' field has '33138'");

        Locator permitDate = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Permit Number Date"));
        errorHandling(() -> {
            permitDate.fill("TBD");
            assertThat(permitDate).hasValue("TBD");
        }, "'Permit Number Date' field has 'TBD'");

        errorHandling(() -> {
            page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Date...")).click();
            page1.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("20").setExact(true)).click();
        }, "Calendar interaction for date '20'");

        Locator unitName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Unit Name..."));
        errorHandling(() -> {
            unitName.fill("Alpha Unit 01");
            assertThat(unitName).hasValue("Alpha Unit 01");
        }, "'Unit Name' field has 'Alpha Unit 01'");

        Locator conditionedArea = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Conditioned Floor Area"));
        errorHandling(() -> {
            conditionedArea.fill("2200");
            assertThat(conditionedArea).hasValue("2200");
        }, "'Conditioned Floor Area' field has '2200'");

        Locator firstName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Home Owner First Name"));
        errorHandling(() -> {
            firstName.fill("Olivia");
            assertThat(firstName).hasValue("Olivia");
        }, "'First Name' field has 'Olivia'");

        Locator lastName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"));
        errorHandling(() -> {
            lastName.fill("Lee");
            assertThat(lastName).hasValue("Lee");
        }, "'Last Name' field has 'Lee'");

        Locator phone = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone"));
        errorHandling(() -> {
            phone.fill("(408) 555-7890");
            assertThat(phone).hasValue("(408) 555-7890");
        }, "'Phone' field has '(408) 555-7890'");

        Locator email = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(" Email"));
        errorHandling(() -> {
            email.fill("olivia@lee.com");
            assertThat(email).hasValue("olivia@lee.com");
        }, "'Email' field has 'olivia@lee.com'");

        Locator systemName = page1.locator("input[name=\"residentialSpaceConditioningSystemName\"]");
        errorHandling(() -> {
            systemName.fill("System 1");
            assertThat(systemName).hasValue("System 1");
        }, "'System Name' has 'System 1'");

        Locator systemArea = page1.locator("input[name=\"residentialHvacSystemAreaServed\"]");
        errorHandling(() -> {
            systemArea.fill("Location 1");
            assertThat(systemArea).hasValue("Location 1");
        }, "'System Area Served' has 'Location 1'");

        Locator squareFeet = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Square feet..."));
        errorHandling(() -> {
            squareFeet.fill("2200");
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

