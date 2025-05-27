package FirstTestSuit.DataInput;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class CF1RALT02E_DataInput {
    public static void run(Page page1) {
        page1.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" Edit")).click();

        Locator projectName = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(" Project Name"));
        projectName.fill("Testing 1");

        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street...")).fill("Florida");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Apt #, Floor, etc...")).fill("3rd Floor");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("City...")).fill("Florida");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("State...")).fill("FL");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Zip...")).fill("33138");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Permit Number Date")).fill("TBD");

        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Date...")).click();
        page1.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("20").setExact(true)).click();

        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Unit Name...")).fill("Alpha Unit 01");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Conditioned Floor Area")).fill("2200");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Home Owner First Name")).fill("Olivia");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill("Lee");

        Locator phone = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone"));
        phone.fill("(408) 555-7890");

        Locator email = page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(" Email"));
        email.fill("olivia@lee.com");

        page1.locator("input[name=\"residentialSpaceConditioningSystemName\"]").fill("System 1");
        page1.locator("input[name=\"residentialHvacSystemAreaServed\"]").fill("Location 1");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Square feet...")).fill("2200");

        page1.getByText("No Alteration Performed").click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add New System")).click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel")).click();

        page1.evaluate("() => { const s = document.querySelector('#climateZone'); s.removeAttribute('disabled'); s.querySelectorAll('option').forEach(o => o.removeAttribute('disabled')); s.value = '5'; s.dispatchEvent(new Event('change', { bubbles: true })); }");
        page1.evaluate("() => { const s = document.querySelector('#A04_ResidentialLowriseBuildingType'); s.removeAttribute('disabled'); s.querySelectorAll('option').forEach(o => o.removeAttribute('disabled')); s.value = 'SingleFamily'; s.dispatchEvent(new Event('change', { bubbles: true })); }");

        // Here I will do some changes
        Locator saveBtn = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save ").setExact(true));
        saveBtn.click();
    }
}
