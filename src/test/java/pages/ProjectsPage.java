package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    public void openPage() {
        open("projects");
    }

    public void waitTillOpened() {
        $(byText("Create new project")).shouldBe(visible);
    }

    public void createProject(String projectName, String projectDescription) {
        // Нажимаем на кнопку создания нового проекта
        $(byText("Create new project")).click();

        // Заполняем поле имени проекта
        fillInputField("Project Name", projectName);

        // Заполняем поле описания проекта
        fillInputField("Description", projectDescription);

        // Нажимаем на кнопку сохранения проекта
        $("[data-testid=save-project-button]").click();

        // Проверяем, что проект был успешно создан
        $(byText(projectName)).shouldBe(visible);
    }

    public void fillInputField(String inputLabel, String value) {
        // Находим поле ввода по метке (label)
        SelenideElement inputField = $(byText(inputLabel))
                .ancestor("label")
                .find("input");

        // Заполняем поле ввода значением
        inputField.setValue(value);
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
