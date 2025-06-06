package FirstTestSuit.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
    private final Page page;
    private final String url = "https://manage.demo.goldenstateregistry.org/admin";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String email, String password) {
        page.navigate(url);
        assertThat(page).hasURL(url);

        Locator emailField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter email..."));
        assertThat(emailField).isVisible();
        emailField.fill(email);

        Locator passwordField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
        assertThat(passwordField).isVisible();
        passwordField.fill(password);

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
    }
}
