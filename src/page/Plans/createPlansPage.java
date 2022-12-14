package page.Plans;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class createPlansPage {

    WebDriver driver;

    public createPlansPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".button.is-info.is-fullwidth")
    public WebElement btnCreatePLan;

    @FindBy(css = "div[class='dropdown is-right is-fullwidth '] i[class='material-icons-outlined is-size-6']")
    public WebElement btnAddUser;

    @FindBy(xpath = "//i[normalize-space()='remove_circle_outline']")
    public WebElement remove_user;

    @FindBy(id = "search_member")
    private WebElement search_member;

    @FindBy(xpath = "(//a[@class='icon is-small has-text-info'])[1]")
    private WebElement chose_user;

    @FindBy(xpath = "//div[contains(@class,'buttons is-right')]//a[contains(@class,'button is-link is-small')]")
    public WebElement done_user;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'dropdown-item py-1')]")
    private List<WebElement> listPosition;

    @FindBy(xpath = "(//ul[contains(@class,'columns is-vcentered is-variable is-1')])[1]")
    private WebElement user1;

    @FindBy(css = "div[class='has-text-right'] a[class='button is-link is-small']")
    public WebElement btnDone_plans;

    @FindBy(id = "plan_name")
    public WebElement txtTitlePlans;

    @FindBy(tagName = "textarea")
    public WebElement txaDescription;

    public void choseMember(String condition) {
        try {
            Thread.sleep(500);
            search_member.sendKeys(condition);
            Thread.sleep(1000);
            chose_user.click();
            Thread.sleep(1000);
            chosePosition("Quản lý");
            done_user.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chosePosition(String codition) {
        try {
            Thread.sleep(1000);
            WebElement chosePosition = user1.findElement(By.className("dropdown-trigger"));
            chosePosition.click();

            Thread.sleep(1000);

            for (WebElement row : listPosition) {
                String namePosition = row.getText().strip();
                if (namePosition.equals(codition)) {
                    row.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeUser() {
        try {
            btnAddUser.click();
            Thread.sleep(1000);
            remove_user.click();
            Thread.sleep(1000);
            done_user.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void txtClear() {
        txtTitlePlans.clear();
        txaDescription.clear();
    }
}
