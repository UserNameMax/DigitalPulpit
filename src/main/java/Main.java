import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class Main {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/home/max/test/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://omgtu.ru/students/pay/");
        driver.manage().window().setSize(new Dimension(1258, 719));
        assertFalse(driver.findElement(By.id("payer_agreement")).isSelected());
        driver.findElement(By.id("payer_agreement")).click();
        assertTrue(driver.findElement(By.id("payer_agreement")).isSelected());
    }
}
