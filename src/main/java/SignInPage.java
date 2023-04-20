import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = By.cssSelector(".auth-form-header > h1:nth-child(1)");

    public String getTitleText(){
        return driver.findElement(title).getText();
    }
}
