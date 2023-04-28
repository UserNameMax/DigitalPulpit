package page;

import model.AuthInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

public class AuthPage {
    private WebDriver driver;
    public AuthPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailInput = By.cssSelector("#\\:r0\\:");
    private By passwordInput = By.cssSelector("#\\:r1\\:");
    private By button = By.cssSelector("#root > div > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation2.Login_paper__EAxtk.css-li77g6 > div > form > div > div:nth-child(5) > button");
    public MainPage Auth(String login, String password){
        driver.findElement(emailInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(button).click();
        return new MainPage(driver);
    }
    public void clearFields(String login, String password){
        for (int i = 0;i<login.length();++i){
            driver.findElement(emailInput).sendKeys(Keys.BACK_SPACE);
        }
        for (int i = 0;i<password.length();++i){
            driver.findElement(passwordInput).sendKeys(Keys.BACK_SPACE);
        }
    }
}
