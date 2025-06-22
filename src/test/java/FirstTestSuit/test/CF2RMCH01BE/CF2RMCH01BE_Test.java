package FirstTestSuit.test.CF2RMCH01BE;


import FirstTestSuit.Assertions.CF1RALT02E.CF1RALT02E_Assertions;
import FirstTestSuit.Assertions.CF2RMCH01BE.CF2RMCH01BE_Assertions;
import FirstTestSuit.Data.CF1RALT02E.CF1RALT02E_DataInput;
import FirstTestSuit.Data.CF2RMCH01BE.CF2RMCH01BE_DataInput;
import FirstTestSuit.base.BaseTest;
import FirstTestSuit.pages.DashboardPage;
import FirstTestSuit.pages.LoginPage;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;
import org.testng.Assert;

public class CF2RMCH01BE_Test extends BaseTest {

    @Test
    public void testFormFilling() throws  InterruptedException{
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("loginEmail", "password");


        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.openPopupAndNavigate("Florida City", "Installation");


        Page page1 = dashboardPage.getPopupPage();
        assertThat(page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Installation"))).isVisible();
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Installation")).click();
        Locator notStartedBtn = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" CF2RMCH01BE not-started"));
        Locator signedBtn = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" CF2RMCH01BE signed"));


        if (notStartedBtn.isVisible()) {
            notStartedBtn.click();
            CF2RMCH01BE_DataInput.run(page1);


            page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Installation")).click();
            Locator signed = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" CF2RMCH01BE signed"));
            assertThat(signed).isVisible();
            signed.click();

            Locator viewBtn = page1.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" View"));
            assertThat(viewBtn).isVisible();
            System.out.println("✅ Form has been saved and signed. 'View' button is visible.");

            CF2RMCH01BE_Assertions.runAssertions(page1);
            Locator saveBtn = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save ").setExact(true));
            saveBtn.click();
            page1.evaluate("() => { const s = document.querySelector('select[name=\"complianceMethod\"]'); s.removeAttribute('disabled'); s.querySelectorAll('option').forEach(o => o.removeAttribute('disabled')); s.value = 'PrescriptiveNewConstruction'; s.dispatchEvent(new Event('change', { bubbles: true })); }");

            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save & Sign")).click();
            page1.locator("input[name='username']").fill("loginEmail");
            page1.locator("input[name='password']").fill("password");
            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign").setExact(true)).click();






        } else if (signedBtn.isVisible()) {
            signedBtn.click();
            System.out.println("ℹ️ Form already signed.");
            page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Installation")).click();

            Locator signed = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" CF2RMCH01BE signed"));
            assertThat(signed).isVisible();
            signed.click();

            Locator viewBtn = page1.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" View"));
            assertThat(viewBtn).isVisible();
            System.out.println("✅ Form has been saved and signed. 'View' button is visible.");

            viewBtn.click();

            CF2RMCH01BE_Assertions.runAssertions(page1);



        } else {
            Assert.fail("❌ Neither 'not-started' nor 'signed' form status found.");
        }
    }
}




