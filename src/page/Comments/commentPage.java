package page.Comments;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import page.indexPage;
import page.Works.subWorksPage;

public class commentPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Bình luận')]")
    public WebElement navigationToComments;

    @FindBy(id = "task_comment")
    private WebElement contentComments;

    @FindBy(xpath = "//a[@class='icon is-small is-right has-text-link']")
    private WebElement btnSend;

    @FindBy(how = How.CSS, using = ".has-text-grey.pl-5.ml-2.mt-1")
    private List<WebElement> listCmts;

    public commentPage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(driver, this);
    }

    public void setContentComments(String content) {
        try {
            contentComments.sendKeys(content);
            Thread.sleep(1000);
            btnSend.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigationToComment() {
        try {

            indexPage index = new indexPage(driver);
            subWorksPage subworks = new subWorksPage(driver);

            index.navigationTo_Task();
            subworks.choseWorks.click();
            index.waitForPageLoaded();

            navigationToComments.click();
            index.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyCmt(String condition) {
        try {
            for (int i = 0; i < listCmts.size(); i++) {
                String nameCmt = listCmts.get(i).getText().strip();
                if (nameCmt.equals(condition)) {
                    System.out.println(nameCmt);
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
