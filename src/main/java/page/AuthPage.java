package page;

import model.AuthInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {
    private WebDriver driver;
    public AuthPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailInput = By.cssSelector("#\\:r0\\:");
    private By passwordInput = By.cssSelector("#\\:r1\\:");
    private By button = By.cssSelector("#root > div > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation2.Login_paper__EAxtk.css-li77g6 > div > form > div > div:nth-child(5) > button");
    public MainPage Auth(){
        driver.findElement(emailInput).sendKeys(AuthInfo.login);
        driver.findElement(passwordInput).sendKeys(AuthInfo.password);
        driver.findElement(button).click();
        return new MainPage(driver);
    }
}
