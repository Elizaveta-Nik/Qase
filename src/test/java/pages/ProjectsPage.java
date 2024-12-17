package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    public void openPage() {
        open("projects");
    }

    public void waitTillOpened() {
        $(byText("Create new project")).shouldBe(visible);
    }

    public void createProject(String projectName, String projectDescription) {
        $(byText("Create new project")).click();
    }

    public void removeProject(String projectName) {
//    $x("//a[contains(text(), Sharelane_QA28)]/ancestor::tr//button[@aria-label='Open action menu']").click();
//     a[contains(text(), Sharelane_QA28)]/ancestor::tr//button[@aria-label='Open action menu']
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $(byText("Delete project")).click();
    }
}
