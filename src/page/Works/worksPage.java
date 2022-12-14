package page.Works;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class worksPage {
    WebDriver driver;

    @FindBy(id = "plan_bubble")
    private WebElement btnTask;

    @FindBy(css = ".button.is-small.is-rounded.is-success")
    private WebElement btnCreateWorks;

    @FindBy(id = "task_name")
    public WebElement txtTaskname;

    @FindBy(css = ".button.is-link.is-small.mr-2")
    private WebElement btnDoneWorks;

    @FindBy(css = "a[class='icon has-background-white has-text-grey is-bordered is-rounded ml-3'] i[class='material-icons-outlined is-size-6']")
    public WebElement btnAddUser;

    @FindBy(xpath = "//i[normalize-space()='remove_circle_outline']")
    public WebElement remove_user;

    @FindBy(xpath = "//div[contains(@class,'buttons is-right')]//a[contains(@class,'button is-link is-small')]")
    public WebElement done_user;

    @FindBy(id = "search_member")
    private WebElement search_member;

    @FindBy(xpath = "(//a[@class='icon is-small has-text-info'])[1]")
    private WebElement chose_user;

    @FindBy(xpath = "(//input[@type='datetime-local'])[1]")
    public WebElement starday;

    @FindBy(xpath = "(//input[@type='datetime-local'])[2]")
    public WebElement endday;

    @FindBy(xpath = "//span[contains(text(),'Chọn nhóm công việc')]")
    private WebElement dropdownTask;

    @FindBy(linkText = "Thực thi automation đạt chuẩn")
    private WebElement choseTask;

    public worksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendKeysDay() {
        try {
            starday.sendKeys("6122022");
            Thread.sleep(1000);
            endday.sendKeys("7122022");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseTask() {
        try {
            dropdownTask.click();
            Thread.sleep(1000);
            choseTask.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void navigationFormWorks() {
        try {
            // btnTask.click();
            Thread.sleep(1000);
            btnCreateWorks.click();
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

    public void choseMember(String condition) {
        try {
            Thread.sleep(500);
            search_member.sendKeys(condition);
            Thread.sleep(1000);
            chose_user.click();
            Thread.sleep(1000);
            done_user.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createWorks(String title) {
        try {
            txtTaskname.sendKeys(title);
            btnDoneWorks.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
