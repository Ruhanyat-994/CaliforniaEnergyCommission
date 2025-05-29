package FirstTestSuit.pages.CF1RALT02E;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CF1RALT02E_LoginPage {
    private final Page page;
    private final String url = "https://manage.demo.goldenstateregistry.org/admin";

    public CF1RALT02E_LoginPage(Page page) {
        this.page = page;
    }

    public void login(String email, String password) {
        // Navigate and assert URL
        page.navigate(url);
        assertThat(page).hasURL(url);

        // Fill email
        Locator emailField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter email..."));
        assertThat(emailField).isVisible();
        emailField.fill(email);

        // Fill password
        Locator passwordField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
        assertThat(passwordField).isVisible();
        passwordField.fill(password);

        // Click Sign In
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
    }
}
