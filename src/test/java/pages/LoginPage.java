package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final String USER = "[name=email]",
            PASSWORD = "[name=password]",
            BUTTON_NAME = "Sign in";

    public void openPage() {
        open("login");
    }

    public void login(String user, String password) {
        $(USER).setValue(user);
        $(PASSWORD).setValue(password);
        $(byText(BUTTON_NAME)).click();
    }
}
