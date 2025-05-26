package FirstTestSuit.pages;



import com.microsoft.playwright.Page;

public class ProjectPage {
    private final Page page;

    public ProjectPage(Page page) {
        this.page = page;
    }

    public void createProject(String projectName) {
        page.click("button#create-project");
        page.fill("input[name='projectName']", projectName);
        page.click("button#submit-project");
    }
}
