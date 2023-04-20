import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    private By projectsButton = By.cssSelector("#root > div > div.MuiDrawer-root.MuiDrawer-docked.LoggedLayout_logo__HuRDk.css-4hdpw5 > div > ul > div:nth-child(5) > div > p");
    private By teamButton = By.cssSelector("#root > div > div.MuiDrawer-root.MuiDrawer-docked.LoggedLayout_logo__HuRDk.css-4hdpw5 > div > ul > div:nth-child(6) > div > p");
    private By clientsButton = By.cssSelector("#root > div > div.MuiDrawer-root.MuiDrawer-docked.LoggedLayout_logo__HuRDk.css-4hdpw5 > div > ul > div:nth-child(7) > div > p");

    public ClientsPage clientsPage(){
        driver.findElement(clientsButton).click();
        return new ClientsPage(driver);
    }

    public ProjectsPage projectsPage() {
        driver.findElement(projectsButton).click();
        return new ProjectsPage(driver);
    }

    public TeamPage teamPage(){
        driver.findElement(teamButton).click();
        return new TeamPage(driver);
    }

}
