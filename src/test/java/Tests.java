import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import model.AuthInfo;
import model.Developer;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/max/test/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1258, 719));
        driver.get("https://olga-finance.effective.band/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //mainPage = new AuthPage(driver).Auth(AuthInfo.login,AuthInfo.password);
    }

    @Test
    @Description(value = "Тест проверяет форму входа")
    public void authTest(){
        auth("adm1n@gmail.com","admin");
        Assert.assertFalse(mainPage.isLogIn());
        saveScreenshotPNG(driver);
        new AuthPage(driver).clearFields("adm1n@gmail.com","o_finance");
        auth(AuthInfo.login,AuthInfo.password);
        Assert.assertTrue(mainPage.isLogIn());
        saveScreenshotPNG(driver);
    }
    @Step
    public void auth(String login, String password){
        mainPage = new AuthPage(driver).Auth(login,password);
    }

    @Step
    public void auth(Integer clientIndex, String projectName) {
        ClientsPage clientsPage = mainPage.clientsPage();
        clientsPage.addProject(clientIndex, projectName);
        Assert.assertTrue(clientsPage.getProjects(clientIndex).contains(projectName));
    }

    @Test
    @Description(value = "Тест проверяет добавление клиента в карточку проекта")
    public void checkClientsTest() {
        auth(AuthInfo.login,AuthInfo.password);
        checkClients(0, "TestProjectChange");
        saveScreenshotPNG(driver);
    }

    @Step
    public void checkClients(Integer clientIndex, String projectName) {
        ClientsPage clientsPage = mainPage.clientsPage();
        clientsPage.addProject(clientIndex, projectName);
        Assert.assertTrue(clientsPage.getProjects(clientIndex).contains(projectName));
    }

    @Test
    @Description(value = "Тест проверяет сортировку команд по rate")
    public void checkTeam() {
        auth(AuthInfo.login,AuthInfo.password);
        TeamPage teamPage = mainPage.teamPage();
        List<Developer> team = teamPage.getTeam();
        team.sort(Comparator.comparingInt((Developer developer) -> developer.rate));
        teamPage.sortByRate();
        Assert.assertEquals(team, teamPage.getTeam());
        saveScreenshotPNG(driver);
    }
    @After
    public void tearDown() {
        try {
            driver.quit();
        } catch (NullPointerException e) {
            System.out.println("error");
        }

    }
}
