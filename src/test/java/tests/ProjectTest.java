package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ProjectTest extends BaseTest{

    @Test
    public void checkCreateProject(){
    loginPage.openPage();
    loginPage.login("nikolaenya.eelizaveta@gmail.com", "!Woofwoof1688");
    projectsPage.waitTillOpened();
    projectsPage.removeProject("Sharelane_QA28");
    }
}
