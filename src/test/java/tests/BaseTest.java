package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectsPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectsPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;

        Configuration.browser = "chrome";//выбор браузера по умолчанию
        Configuration.headless = false;//или true
        Configuration.timeout = 10000;//ожидание любых условий
        Configuration.clickViaJs = true;//клики с помощью JS
        Configuration.baseUrl = "https://app.qase.io/";
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
//        Configuration.assertionMode = AssertionMode.valueOf("SOFT");//для софт ассертов
        //getWebDriver();// есть еще setWebDriver()

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}
