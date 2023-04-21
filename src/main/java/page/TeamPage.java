package page;

import model.Developer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class TeamPage {
    private WebDriver driver;
    private By selectDevelopsCount = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div.Team_wrapper__u92HK > div.Team_tableView__q1dFA > div > div:nth-child(2) > div > div > div.MuiInputBase-root.MuiInputBase-colorPrimary.css-rmmij8");
    private By maxCount = By.cssSelector("#menu- > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c");
    public TeamPage(WebDriver driver){
        this.driver = driver;
        driver.findElement(selectDevelopsCount).click();
        driver.findElement(maxCount).findElements(By.tagName("li")).get(2).click();
    }

    private By sortButton = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div.Team_wrapper__u92HK > div.Team_tableView__q1dFA > div > div.MuiTableContainer-root.TableTeam_container__TgCP9.MuiBox-root.css-1p6ntod > table > thead > tr > th:nth-child(7) > span");
    public void sortByRate(){
        driver.findElement(sortButton).click();
    }

    private By table = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div.Team_wrapper__u92HK > div.Team_tableView__q1dFA > div > div.MuiTableContainer-root.TableTeam_container__TgCP9.MuiBox-root.css-1p6ntod > table > tbody");

    public List<Developer> getTeam(){
        List<Developer> team = new LinkedList();
        List<WebElement> rows = driver.findElement(table).findElements(By.tagName("tr"));
        for (WebElement row: rows){
            List<WebElement> elements = row.findElements(By.tagName("td"));
            team.add(new Developer(elements.get(2).getText(),Integer.parseInt(elements.get(6).getText())));
        }
        return team;
    }
}
