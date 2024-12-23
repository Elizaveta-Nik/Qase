package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    String user = "nikolaenya.eelizaveta@gmail.com";
    String password = "!Woofwoof1688";

    @Test
    public void checkCreateProjectAndTestKeys() {
        loginPage.openPage()
                .login(user, password);
        projectsPage.waitTillOpened()
                .createProject("Heroky", "wow")
                .openPage()
                .shouldHaveProject()
                .showProject("Heroky");

        repositoryPage.createCase("oky", "wewe", "qwwww", "qqqq", 2,
                        4, 2, 2, 2, 1)
                .shouldHaveTestCase("oky");

        projectsPage.openPage()
                .removeProject("Heroky")
                .shouldNotHaveProject();
    }
}