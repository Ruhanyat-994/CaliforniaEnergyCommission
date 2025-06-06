package FirstTestSuit.Data.CF2RMCH01BE;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CF2RMCH01BE_DataInput {
    public static void run(Page page1){

        page1.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" Edit")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Unit Name...")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Unit Name...")).fill("Florida 2");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Conditioned Floor Area")).dblclick();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Conditioned Floor Area")).fill("3000");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of Space Conditioning")).dblclick();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of Space Conditioning")).fill("1");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of bedrooms...")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of bedrooms...")).fill("5");
        page1.evaluate("() => { const s = document.querySelector('select[name='complianceMethod']'); s.removeAttribute('disabled'); s.querySelectorAll('option').forEach(o => o.removeAttribute('disabled')); s.value = 'PrescriptiveNewConstruction'; s.dispatchEvent(new Event('change', { bubbles: true })); }");

        page1.locator("input[name='residentialSpaceConditioningSystemName']").dblclick();
        page1.locator("input[name='residentialSpaceConditioningSystemName']").fill("System 1");
        page1.locator("input[name='residentialHvacSystemAreaServed']").dblclick();
        page1.locator("input[name='residentialHvacSystemAreaServed']").fill("Location 1");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Square feet...")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Square feet...")).fill("3000");
        page1.getByText("No Alteration Performed").click();
        page1.getByText("No Heating Components Altered").click();
        page1.getByText("No Heating Components Altered").click();
        page1.getByText("No Cooling Components Altered").click();
        page1.getByText("No Cooling Components Altered").click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of units...")).dblclick();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("# of units...")).fill("1");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Manufacturer...")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Manufacturer...")).fill("John Smith");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Model Number...")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Model Number...")).fill("11111");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Serial Number...")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Serial Number...")).fill("151");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Output (Btu/h)")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Output (Btu/h)")).fill("5000");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Tonnage...")).click();

    }

}
