package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class TextInput {
    private final String inputXPath;

    public TextInput(String inputXPath) {
        this.inputXPath = inputXPath;
    }

    public void setValue(String value) {
        $x(inputXPath).setValue(value);
    }

    public String getValue() {
        return $x(inputXPath).getValue(); // getValue() если понадобится вернуть текущее значение поля
    }
}