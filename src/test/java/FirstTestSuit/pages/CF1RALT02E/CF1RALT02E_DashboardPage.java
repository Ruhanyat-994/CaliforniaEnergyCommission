package FirstTestSuit.pages.CF1RALT02E;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CF1RALT02E_DashboardPage {
    private final Page page;
    private Page popupPage;

    public CF1RALT02E_DashboardPage(Page page) {
        this.page = page;
    }

    /**
     * Waits for the popup triggered by clicking a link with given popupTriggerName,
     * then navigates to a section link with given sectionLinkName in the popup.
     *
     * @param popupTriggerName The name of the link that triggers the popup (e.g., "Florida")
     * @param sectionLinkName  The name of the link to click inside the popup (e.g., "Compliance")
     */
    public void openPopupAndNavigate(String popupTriggerName, String sectionLinkName) {
        popupPage = page.waitForPopup(() -> {
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(popupTriggerName)).click();
        });

        assertThat(popupPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(sectionLinkName))).isVisible();
        popupPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(sectionLinkName)).click();
    }

    public Page getPopupPage() {
        return popupPage;
    }
}
