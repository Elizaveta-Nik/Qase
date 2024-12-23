package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private static final String ACTION_MENU = "button[aria-label='Open action menu']",
            REMOVE_BUTTON = "[data-testid=remove]",
            DELETE_BUTTON = "//button/span[text()='Delete project']",
            CREATE_NEW_PROJECT = "Create new project",
            PROJECT_NAME_CREATE = "#project-name",
            DESCRIPTION_AREA = "#description-area",
            CREATE_PROJECT_BUTTON = "Create project",
            PROJECT_NAME = "//a[text()='%s']";

    public ProjectsPage openPage() {
        open("projects");
        return this;
    }

    public ProjectsPage waitTillOpened() {
        $(byText(CREATE_NEW_PROJECT)).shouldBe(visible);
        return this;
    }

    public ProjectsPage createProject(String projectName, String projectDescription) {
        openPage();
        $(byText(CREATE_NEW_PROJECT)).click();

        $(PROJECT_NAME_CREATE).setValue(projectName);
        $(DESCRIPTION_AREA).setValue(projectDescription);
        $(byText(CREATE_PROJECT_BUTTON)).click();
        return this;
    }

    public ProjectsPage removeProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find(ACTION_MENU)
                .click();
        $(REMOVE_BUTTON).click();
        $x(DELETE_BUTTON).click();
        $(byText(projectName)).shouldNotBe(visible);
        return this;
    }

    public ProjectsPage showProject(String projectName) {
        $x(String.format(PROJECT_NAME, projectName)).click();
        return this;
    }

    public ProjectsPage shouldHaveProject() {
        $(byText("Heroky")).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage shouldNotHaveProject() {
        $(byText("Heroky")).shouldNotBe(visible);
        return this;
    }
}