package page.todolist;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import page.indexPage;
import page.Works.subWorksPage;

public class todolistPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='button is-small is-white'][contains(text(),'Todolist liên kết')]")
    private WebElement navigationtodolist;

    @FindBy(xpath = "//a[@class='icon has-text-link is-medium']")
    private WebElement btnAddTodolist;

    @FindBy(id = "task_todo")
    public WebElement txtTaskTodo;

    @FindBy(xpath = "(//input[@type='datetime-local'])[3]")
    private WebElement starday;

    @FindBy(xpath = "(//input[@type='datetime-local'])[4]")
    private WebElement endday;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement btnSave;

    @FindBy(how = How.CSS, using = ".font_14.has-text-weight-medium")
    private List<WebElement> listTodolist;

    public todolistPage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(driver, this);
    }

    public void navigationTodolist() {
        try {

            indexPage index = new indexPage(driver);
            subWorksPage subworks = new subWorksPage(driver);

            index.navigationTo_Task();
            subworks.choseWorks.click();
            index.waitForPageLoaded();

            navigationtodolist.click();
            index.waitForPageLoaded();
            btnAddTodolist.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setText(String text, String star, String end) {
        try {

            txtTaskTodo.sendKeys(text);
            starday.sendKeys(star);

            Thread.sleep(1000);
            endday.sendKeys(end);

            Thread.sleep(1000);

            btnSave.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyTodolist(String condition) {
        try {
            for (int i = 0; i < listTodolist.size(); i++) {
                String nameTodolist = listTodolist.get(i).getText().strip();
                if (nameTodolist.equals(condition)) {
                    System.out.println(nameTodolist);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
