package pages;

import com.codeborne.selenide.Condition;
import wrappers.Dropdown;
import wrappers.TextInput;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RepositoryPage {

    private static final String CREATE_BUTTON = "#create-case-button",
            TITLE = "#title",
            DESCRIPTION = "//label[contains(@for,'0-description')]/parent::div//p",
            MUTED_CASE = "//*[@id='is_muted']/parent::span",
            PRECONDITIONS = "//label[contains(@for,'0-preconditions')]/parent::div//p",
            POSTCONDITIONS = "//label[contains(@for,'0-postconditions')]/parent::div//p",
            BUTTON_SAVE = "//button/span[text()='Save']";

    private final TextInput descriptionInput;
    private final TextInput preconditionsInput;
    private final TextInput postconditionsInput;

    private final Map<String, Dropdown> dropdowns = new HashMap<>();

    public RepositoryPage() {
        this.descriptionInput = new TextInput(DESCRIPTION);
        this.preconditionsInput = new TextInput(PRECONDITIONS);
        this.postconditionsInput = new TextInput(POSTCONDITIONS);

        dropdowns.put("status", new Dropdown("//div[contains(@id,'0-status')]", "0-status"));
        dropdowns.put("severity", new Dropdown("//div[contains(@id,'0-severity')]", "0-severity"));
        dropdowns.put("priority", new Dropdown("//div[contains(@id,'0-priority')]", "0-priority"));
        dropdowns.put("type", new Dropdown("//div[contains(@id,'0-type')]", "0-type"));
        dropdowns.put("layer", new Dropdown("// div[contains(@id,'0-layer')]", "0-layer"));
        dropdowns.put("isFlaky", new Dropdown("//div[contains(@id,'0-is_flaky')]", "0-is_flaky"));
        dropdowns.put("behavior", new Dropdown("//div[contains(@id,'0-behavior')]", "0-behavior"));
        dropdowns.put("automation", new Dropdown("//div[contains(@id,'0-isManual')]", "0-isManual"));
    }

    public RepositoryPage createCase(String title, String description, String preconditions, String postconditions, int statusOption,
                                     int severityOption, int priorityOption, int typeOption, int layerOption, int isFlakyOption) {
        $(CREATE_BUTTON).click();

        $(TITLE).setValue(title);
        descriptionInput.setValue(description);
        preconditionsInput.setValue(preconditions);
        postconditionsInput.setValue(postconditions);

        dropdowns.get("status").selectOption(statusOption);
        dropdowns.get("severity").selectOption(severityOption);
        dropdowns.get("priority").selectOption(priorityOption);
        dropdowns.get("type").selectOption(typeOption);
        dropdowns.get("layer").selectOption(layerOption);
        dropdowns.get("isFlaky").selectOption(isFlakyOption);
        dropdowns.get("behavior").selectOption(2);
        dropdowns.get("automation").selectOption(1);

        $x(MUTED_CASE).click();
        $x(BUTTON_SAVE).click();
        return this;
    }

    public RepositoryPage shouldHaveTestCase(String testCaseName) {
        $(byText("oky")).shouldBe(Condition.visible);
        return this;
    }

    public RepositoryPage waitTillOpened() {
        $(byText("Heroky")).shouldNotBe(Condition.visible);
        return this;
    }
}