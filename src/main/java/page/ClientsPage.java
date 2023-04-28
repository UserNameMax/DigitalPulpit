package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class ClientsPage {
    private WebDriver driver;
    private By table = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div.Clients_wrapper__yWZUI > div.Clients_tableView__E4wPk > div > div.MuiTableContainer-root.TableClients_container__teR\\+L.css-kge0eu > table > tbody");
    private By changeButton = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-1.ClientProfileModal_gridBox__VtQi\\+.css-tuxzvu > div:nth-child(3) > button");
    private By saveProjectButton = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div.ClientProfileModal_buttonBox__Fgvho.MuiBox-root.css-0 > button.MuiButtonBase-root.MuiButton-root.MuiButton-text.MuiButton-textPrimary.MuiButton-sizeMedium.MuiButton-textSizeMedium.ClientProfileModal_save__-kUy8.css-j6crq6");
   private By projectNameField = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div.ClientProfileModal_textFieldBox__-MD4o.MuiBox-root.css-0 > div:nth-child(3) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-7.css-7vy65v > div > div > div");
    public ClientsPage(WebDriver driver){
        this.driver = driver;
    }

    public void addProject(int clientIndex, String projectName){
        driver.findElement(table).findElements(By.tagName("tr")).get(clientIndex).click();
        driver.findElement(changeButton).click();
        WebElement field = driver.findElement(projectNameField).findElement(By.tagName("input"));
        field.sendKeys(projectName);
        field.sendKeys(Keys.DOWN);
        field.sendKeys(Keys.ENTER);
        driver.findElement(saveProjectButton).click();
    }

    public List<String> getProjects(int clientIndex){
        WebElement client = driver.findElement(table).findElements(By.tagName("tr")).get(clientIndex);
        List<String> projects = new LinkedList<>();
        for (WebElement project: client.findElements(By.tagName("span"))){
            projects.add(project.getText());
        };
        return projects;
    }
}
