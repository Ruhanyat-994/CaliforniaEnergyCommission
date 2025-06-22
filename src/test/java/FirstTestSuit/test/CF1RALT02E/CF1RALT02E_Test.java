package FirstTestSuit.test.CF1RALT02E;


import FirstTestSuit.Assertions.CF1RALT02E.CF1RALT02E_Assertions;
import FirstTestSuit.Data.CF1RALT02E.CF1RALT02E_DataInput;
import FirstTestSuit.base.BaseTest;
import FirstTestSuit.pages.DashboardPage;
import FirstTestSuit.pages.LoginPage;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;
import org.testng.Assert;

    public class CF1RALT02E_Test extends BaseTest {

        @Test
        public void testFormFilling() throws  InterruptedException{
            LoginPage loginPage = new LoginPage(page);
            loginPage.login("loginEmail", "password");


            DashboardPage dashboardPage = new DashboardPage(page);
            dashboardPage.openPopupAndNavigate("Testing 1", "Compliance");


            Page page1 = dashboardPage.getPopupPage();
            assertThat(page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Compliance"))).isVisible();
            page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Compliance")).click();
            Locator notStartedBtn = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" CF1RALT02E not-started"));
            Locator signedBtn = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" CF1RALT02E signed"));


            if (notStartedBtn.isVisible()) {
                notStartedBtn.click();
                CF1RALT02E_DataInput.run(page1);


                page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Compliance")).click();
                Locator signed = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" CF1RALT02E signed"));
                assertThat(signed).isVisible();
                signed.click();

                Locator viewBtn = page1.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" View"));
                assertThat(viewBtn).isVisible();
                System.out.println("✅ Form has been saved and signed. 'View' button is visible.");

                CF1RALT02E_Assertions.runAssertions(page1);

                Locator saveBtn = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save ").setExact(true));
                saveBtn.click();
                page1.evaluate("() => { const s = document.querySelector('#climateZone'); s.removeAttribute('disabled'); s.querySelectorAll('option').forEach(o => o.removeAttribute('disabled')); s.value = '5'; s.dispatchEvent(new Event('change', { bubbles: true })); }");
                page1.evaluate("() => { const s = document.querySelector('#A04_ResidentialLowriseBuildingType'); s.removeAttribute('disabled'); s.querySelectorAll('option').forEach(o => o.removeAttribute('disabled')); s.value = 'SingleFamily'; s.dispatchEvent(new Event('change', { bubbles: true })); }");


                page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save & Sign")).click();
                page1.locator("input[name='username']").fill("loginEmail");
                page1.locator("input[name='password']").fill("password");
                page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign").setExact(true)).click();





            } else if (signedBtn.isVisible()) {
                signedBtn.click();
                System.out.println("ℹ️ Form already signed.");
                page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Compliance")).click();

                Locator signed = page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" CF1RALT02E signed"));
                assertThat(signed).isVisible();
                signed.click();

                Locator viewBtn = page1.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" View"));
                assertThat(viewBtn).isVisible();
                System.out.println("✅ Form has been saved and signed. 'View' button is visible.");

                viewBtn.click();

                CF1RALT02E_Assertions.runAssertions(page1);

                Thread.sleep(3000);

            } else {
                Assert.fail("❌ Neither 'not-started' nor 'signed' form status found.");
            }
        }
    }




