package page.Works;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import page.indexPage;

public class subWorksPage {

    WebDriver driver;

    @FindBy(linkText = "Lập plan để thực thi")
    public WebElement choseWorks;

    @FindBy(xpath = "//a[contains(text(),'Công việc phụ')]")
    private WebElement navigationTosubWorks;

    @FindBy(xpath = "//a[.='add_box']")
    private WebElement btnCreateSubWorks;

    @FindBy(xpath = "//input[@placeholder='Nhập tiêu đề công việc']")
    private WebElement txtTitleSubWorks;

    @FindBy(tagName = "textarea")
    private WebElement txaDescription;

    @FindBy(xpath = "(//input[@type='datetime-local'])[3]")
    private WebElement starday;

    @FindBy(xpath = "(//input[@type='datetime-local'])[4]")
    private WebElement endday;

    @FindBy(xpath = "//a[@class='button is-small is-white has-text-link']")
    private WebElement btnSave;

    @FindBy(how = How.CSS, using = "li[class='column is-11']")
    private List<WebElement> listSubWorks;

    @FindBy(css = "a[class='icon has-background-white has-text-grey is-bordered is-rounded '] i[class='material-icons-outlined is-size-6']")
    public WebElement btnAddUser;

    public subWorksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    indexPage index = new indexPage(driver);

    public void navigationTo_SubWorks() {
        try {
            choseWorks.click();
            index.waitForPageLoaded();
            navigationTosubWorks.click();
            Thread.sleep(2000);
            btnCreateSubWorks.click();
            index.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyListSubWorks(String condition) {
        try {
            for (int i = 0; i < listSubWorks.size(); i++) {
                String subWorks = listSubWorks.get(i).getText().strip();
                if (subWorks.equals(condition)) {
                    System.out.println(subWorks);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void choseTime() {
        try {
            starday.sendKeys("6122022");
            Thread.sleep(1000);
            endday.sendKeys("7122022");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setText(String title, String text) {
        txtTitleSubWorks.sendKeys(title);
        txaDescription.sendKeys(text);
        btnSave.click();
    }

    public void clear() {
        try {
            txtTitleSubWorks.clear();
            txaDescription.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
