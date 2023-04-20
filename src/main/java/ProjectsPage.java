import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ProjectsPage {
    private WebDriver driver;

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(itemOnPage).click();
        driver.findElement(maxItemOnPage).click();
    }

    private By addProjectButton = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div.Projects_wrapper__nFoBm > div.TitleManagementPages_wrapper__JjMI9 > div.TitleManagementPages_titleContainer__eMkFF > div.TitleManagementPages_button__pSPkk > div > button > svg");
    private By projectNameField = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div > div:nth-child(2) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-9.css-14ybvol > div > div");
    private By clientField = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div > div:nth-child(3) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-9.css-14ybvol > div > div");
    private By colorTableField = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div > div:nth-child(4) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-9.css-14ybvol > div");
    ;
    private By clients = By.cssSelector("#menu- > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul");
    private By colors = By.cssSelector("#menu- > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul");

    private By nextPageButton = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div.Projects_wrapper__nFoBm > div.Projects_tableView__D4DTG > div > div:nth-child(2) > div > div > div.MuiTablePagination-actions > button.MuiButtonBase-root.Mui-disabled.MuiIconButton-root.Mui-disabled.MuiIconButton-colorInherit.MuiIconButton-sizeMedium.css-1deacqj");
    private By table = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div.Projects_wrapper__nFoBm > div.Projects_tableView__D4DTG > div > div.MuiTableContainer-root.TableProjects_container__fo013.css-kge0eu > table > tbody");
    private By itemOnPage = By.cssSelector("#root > div > div.LoggedLayout_longHeader__Cn0D\\+ > div.Projects_wrapper__nFoBm > div.Projects_tableView__D4DTG > div > div:nth-child(2) > div > div > div.MuiInputBase-root.MuiInputBase-colorPrimary.css-rmmij8");
    private By maxItemOnPage = By.cssSelector("#menu- > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(3)");

    void addProject(String name, String clientName, String colorName) {
        driver.findElement(addProjectButton).click();
        driver.findElement(projectNameField).sendKeys(name);
        driver.findElement(clientField).click();
        clickOnItem(clientName, clients);
        clickOnItem(colorName, colors);
    }

    List<ProjectInfo> projects() {
        WebElement nextButton = driver.findElement(nextPageButton);
        List<ProjectInfo> result = new LinkedList();
        //while (nextButton.isEnabled()){
        WebElement tableElement = driver.findElement(table);
        tableElement.findElements(By.tagName("tr")).forEach((row) -> {
            result.add(new ProjectInfo(Integer.parseInt(row.findElements(By.tagName("td")).get(0).getText()),
                    row.findElements(By.tagName("td")).get(1).getText(),row.findElements(By.tagName("td")).get(5).getText()));
        });

        //nextButton.click(); //element click intercepted
        //}
        return result;
    }

    private By changeProjectNameField = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div.ProjectAdminModal_textFieldBox__6zvPl.MuiBox-root.css-0 > div:nth-child(1) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-9.css-14ybvol > div > div");
    private By projectManagerList = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div.ProjectAdminModal_textFieldBox__6zvPl.MuiBox-root.css-0 > div:nth-child(3) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-9.css-14ybvol > div > div");
    private By saveButton = By.cssSelector("body > div.MuiDialog-root.ProfileLayout_modal__X6iNe.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn > div > div > div.ProjectAdminModal_textFieldBox__6zvPl.MuiBox-root.css-0 > div.ProjectAdminModal_buttonBox__NSMiF.MuiBox-root.css-0 > button.MuiButtonBase-root.MuiButton-root.MuiButton-text.MuiButton-textPrimary.MuiButton-sizeMedium.MuiButton-textSizeMedium.ProjectAdminModal_save__Re6RJ.css-j6crq6");
    private By projectManagers = By.cssSelector("#menu- > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul");
    void updateProject(ProjectInfo project, String newName, String newProjectManager){
        driver.findElement(table).findElements(By.tagName("tr")).get(project.index-1).click();
        WebElement field = driver.findElement(changeProjectNameField).findElement(By.tagName("input"));
        for (int i = 0; i < project.name.length();++i){
            field.sendKeys(Keys.BACK_SPACE);
        }
        field.sendKeys(newName);
        driver.findElement(projectManagerList).click();
        List<WebElement> manager = driver.findElement(projectManagers).findElements(new By.ByTagName("li"));
        List<String> str = manager.stream().map((item)->item.getText()).collect(Collectors.toList());
        manager.removeIf((item)-> !Objects.equals(item.getText(), newProjectManager));
        manager.get(0).click();
        driver.findElement(saveButton).click();
    }

    void clickOnItem(String itemName, By list) {
        List<WebElement> itemsList = driver.findElements(list);
        itemsList.removeIf((item) -> item.getText() != itemName);
        itemsList.get(0).click();
    }

}
