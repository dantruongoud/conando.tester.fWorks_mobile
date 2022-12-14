package page.History;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class historyPlansPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(.,'Lịch sử cập nhật')]")
    public WebElement navigation_history;

    @FindBy(how = How.CSS, using = ".item.pb-4")
    private List<WebElement> listTask;

    @FindBy(css = ".has-text-weight-semibold.has-text-info")
    private WebElement nameTask;

    @FindBy(css = ".py-1")
    private WebElement timeTask;

    @FindBy(xpath = "//span[4]")
    private WebElement user_incharge;

    public historyPlansPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getTitleTask() {

        System.out.println();

        for (int i = 0; i < listTask.size(); i++) {
            String title = listTask.get(i).getText().strip();
            System.out.println(title);

            String user_incharge = listTask.get(i).findElement(By.cssSelector(".image.is-24x24.is-rounded"))
                    .getAttribute("title");
            System.out.println(user_incharge);
            System.out.println();
        }
    }
}
