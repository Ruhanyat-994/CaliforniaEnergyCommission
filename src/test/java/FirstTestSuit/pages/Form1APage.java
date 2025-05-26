package FirstTestSuit.pages;

import com.microsoft.playwright.Page;

import java.util.Map;

public class Form1APage {
    private final Page page;

    public Form1APage(Page page) {
        this.page = page;
    }

    public void fillForm(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            page.fill("input[name='" + entry.getKey() + "']", entry.getValue());
        }
    }

    public void submitForm() {
        page.click("button:has-text('Save and Sign')");
    }

    public String getCalculatedValue(String fieldName) {
        return page.inputValue("input[name='" + fieldName + "']");
    }
}

