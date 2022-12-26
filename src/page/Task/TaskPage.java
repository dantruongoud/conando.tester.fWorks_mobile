package page.Task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {

    WebDriver driver;

    @FindBy(id = "plan_bubble")
    private WebElement btnTask;

    @FindBy(css = ".button.is-small.is-rounded.is-info")
    private WebElement btnCreateTask;

    @FindBy(css = "[placeholder='Nhập tiêu đề nhóm công việc...']")
    private WebElement txtTitleTask;

    @FindBy(css = ".is-left")
    private WebElement btnDoneTask;

    public TaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createTask(String title) {
        try {
            txtTitleTask.sendKeys(title);
            btnDoneTask.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigationFormTask() {
        try {
            if (btnCreateTask.isDisplayed()) {
                btnCreateTask.click();
            } else {
                btnTask.click();
                Thread.sleep(500);
                btnCreateTask.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
