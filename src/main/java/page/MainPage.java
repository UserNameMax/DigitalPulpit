package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.ClientsPage;

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

    private By userLogo = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div:nth-child(1) > div.MuiToolbar-root.MuiToolbar-gutters.MuiToolbar-regular.Header_header__OKWO7.css-i6s8oy > div:nth-child(2) > div.Header_headerItem__vJr5d.Header_avatar__H1JXw > span > div > div");
    private By logOutButton = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div:nth-child(1) > div.AvatarMenu_wrapper__PXmpj > div > div.AvatarMenu_menu__NsMRs > ul > li:nth-child(2) > div");
    private By logOutYesButton = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div > div.Logout_buttonBox__oKKq\\+.MuiBox-root.css-0 > button.MuiButtonBase-root.MuiButton-root.MuiButton-text.MuiButton-textPrimary.MuiButton-sizeMedium.MuiButton-textSizeMedium.Logout_yes__L0GgN.css-1ujsas3");
    public void logOut(){
        driver.findElement(userLogo).click();
        driver.findElement(logOutButton).click();
        driver.findElement(logOutButton).click();
    }

    public boolean isLogIn(){
        return !driver.findElements(userLogo).isEmpty();
    }

}
