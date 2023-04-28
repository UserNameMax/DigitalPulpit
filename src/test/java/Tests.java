import io.qameta.allure.Step;
import model.Developer;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.*;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tests {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/max/test/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1258, 719));
        driver.get("https://olga-finance.effective.band/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        mainPage = new AuthPage(driver).Auth();
    }

    @Test
    public void checkClientsTest() {
        checkClients(0, "TestProjectChange");
    }

    @Step
    public void checkClients(Integer clientIndex, String projectName) {
        ClientsPage clientsPage = mainPage.clientsPage();
        clientsPage.addProject(clientIndex, projectName);
        Assert.assertTrue(clientsPage.getProjects(clientIndex).contains(projectName));
    }

    @Test
    public void checkTeam() {
        TeamPage teamPage = mainPage.teamPage();
        List<Developer> team = teamPage.getTeam();
        team.sort(Comparator.comparingInt((Developer developer) -> developer.rate));
        teamPage.sortByRate();
        Assert.assertEquals(team, teamPage.getTeam());
    }

    /*@Test
    public void checkProjects(){
        ProjectsPage projectsPage = mainPage.projectsPage();
        //projectsPage.addProject("TestProject","OOO \"ZZ\"","Yellow"); // не добавляю чтобы не мусорить
        List<ProjectInfo> projects = projectsPage.projects();
        //проверка добавления
        Assert.assertTrue(projects.stream().map((item)->item.name).collect(Collectors.toList()).contains("TestProject"));
        projectsPage.updateProject(projects.get(projects.size()-1),"TestProjectChange","Alex Semenenko");
        projects = projectsPage.projects();
        //проверка обновления менеджера
        Assert.assertEquals("Alex Semenenko",projects.get(projects.size()-1).projectManager);
        //проверка изменения имени
        Assert.assertEquals("TestProjectChange",projects.get(projects.size()-1).name);
        /*SignInPage signInPage = mainPage.signIn();
        Assert.assertEquals("Sign in to GitHub",signInPage.getTitleText());
    }
    */
    @After
    public void tearDown() {
        try {
            driver.quit();
        } catch (NullPointerException e) {
            System.out.println("error");
        }

    }
}
