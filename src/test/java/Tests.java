import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Tests {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/home/max/test/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1258, 719));
        driver.get("https://olga-finance.effective.band/");
        driver.manage().timeouts().implicitlyWait (15, TimeUnit.SECONDS);
        mainPage = new AuthPage(driver).Auth();
    }

    @Test
    public void checkProjects(){
        ProjectsPage projectsPage = mainPage.projectsPage();
        List<ProjectInfo> projects = projectsPage.projects();
        Assert.assertTrue(projects.stream().map((item)->item.name).collect(Collectors.toList()).contains("test case"));
        projectsPage.updateProject(projects.get(projects.size()-1),"TestProjectChange","Alex Semenenko");
        projects = projectsPage.projects();
        Assert.assertEquals("Alex Semenenko",projects.get(projects.size()-1).projectManager);
        Assert.assertEquals("TestProjectChange",projects.get(projects.size()-1).name);
        /*SignInPage signInPage = mainPage.signIn();
        Assert.assertEquals("Sign in to GitHub",signInPage.getTitleText());*/
    }
    @After
    public void tearDown(){
        try{
            driver.quit();
        }
        catch (NullPointerException e){
            System.out.println("error");
        }

    }
}
