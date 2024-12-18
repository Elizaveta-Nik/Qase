package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    private final String dropdownXPath;
    private final String optionBaseId;

    public Dropdown(String dropdownXPath, String optionBaseId) {
        this.dropdownXPath = dropdownXPath;
        this.optionBaseId = optionBaseId;
    }

    public void selectOption(int optionNumber) {
        $x(dropdownXPath).click();
        String optionXPath = String.format("//*[@id='%s-listbox']//div[contains(@id,'%s-option-%d')]",
                optionBaseId, optionBaseId, optionNumber);
        $x(optionXPath).click();
    }
}