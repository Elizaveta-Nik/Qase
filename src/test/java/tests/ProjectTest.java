package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    String user = "nikolaenya.eelizaveta@gmail.com";
    String password = "!Woofwoof1688";

    @Test
    public void checkValidLogin() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitTillOpened();
    }

    @Test
    public void checkCreateProject() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitTillOpened();
        projectsPage.createProject("qwerty", "wow");
    }

    @Test
    public void checkCreateTestKeys() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitTillOpened();
        projectsPage.showProject("qwerty");

        repositoryPage.createCase("qwwe", "wewe", "qwwww", "qqqq", 2,
                4, 2, 2, 2, 1);
        repositoryPage.waitTillOpened();
    }

    @Test
    public void checkDeleteProject() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitTillOpened();
        projectsPage.removeProject("Heroky");
    }
}