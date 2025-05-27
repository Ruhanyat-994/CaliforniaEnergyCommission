package FirstTestSuit.Assertions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CF1RALT02E_Assertions {

    public static void runAssertions(Page page1) {
        Locator projectInput = page1.locator("input#name");
        assertThat(projectInput).isVisible();
        assertThat(projectInput).hasValue("Testing 1");
        System.out.println("✅ 'Project Name' input is present and contains 'Testing 1'.");

        Locator street = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street..."));
        assertThat(street).hasValue("Florida");
        street.fill("Florida");
        assertThat(street).hasValue("Florida");

        Locator apt = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Apt #, Floor, etc..."));
        apt.fill("3rd Floor");
        assertThat(apt).hasValue("3rd Floor");

        Locator city = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("City..."));
        city.fill("Florida");
        assertThat(city).hasValue("Florida");

        Locator state = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("State..."));
        state.fill("FL");
        assertThat(state).hasValue("FL");

        Locator zip = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Zip..."));
        zip.fill("33138");
        assertThat(zip).hasValue("33138");

        Locator permitDate = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Permit Number Date"));
        permitDate.fill("TBD");
        assertThat(permitDate).hasValue("TBD");

        // Calendar interaction (click only)
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Date...")).click();
        page1.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("20").setExact(true)).click();

        Locator unitName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Unit Name..."));
        unitName.fill("Alpha Unit 01");
        assertThat(unitName).hasValue("Alpha Unit 01");

        Locator conditionedArea = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Conditioned Floor Area"));
        conditionedArea.fill("2200");
        assertThat(conditionedArea).hasValue("2200");

        Locator firstName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Home Owner First Name"));
        firstName.fill("Olivia");
        assertThat(firstName).hasValue("Olivia");

        Locator lastName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"));
        lastName.fill("Lee");
        assertThat(lastName).hasValue("Lee");

        Locator phone = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone"));
        phone.fill("(408) 555-7890");
        assertThat(phone).hasValue("(408) 555-7890");

        Locator email = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(" Email"));
        email.fill("olivia@lee.com");
        assertThat(email).hasValue("olivia@lee.com");

        Locator systemName = page1.locator("input[name=\"residentialSpaceConditioningSystemName\"]");
        systemName.fill("System 1");
        assertThat(systemName).hasValue("System 1");

        Locator systemArea = page1.locator("input[name=\"residentialHvacSystemAreaServed\"]");
        systemArea.fill("Location 1");
        assertThat(systemArea).hasValue("Location 1");

        Locator squareFeet = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Square feet..."));
        squareFeet.fill("2200");
        assertThat(squareFeet).hasValue("2200");

        // Checkbox or Radio button: "No Alteration Performed"
        Locator noAlterationCheckbox = page1.getByLabel("No Alteration Performed");
        assertThat(noAlterationCheckbox).isVisible();
        assertThat(noAlterationCheckbox).isChecked();

        System.out.println("✅ Giving Everything");
    }
}
