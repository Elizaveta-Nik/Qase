package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final String USER = "[name=email]",
            PASSWORD = "[name=password]",
            BUTTON_NAME = "Sign in";

    public LoginPage openPage() {
        open("login");
        return this;
    }

    public LoginPage login(String user, String password) {
        $(USER).setValue(user);
        $(PASSWORD).setValue(password);
        $(byText(BUTTON_NAME)).click();
        return this;
    }
}