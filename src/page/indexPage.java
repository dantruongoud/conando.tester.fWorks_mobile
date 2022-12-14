package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class indexPage {

    private WebDriver driver;

    @FindBy(css = "input[placeholder='Nhập email...']")
    private WebElement username;

    @FindBy(css = "input[placeholder='Nhập mật khẩu...']")
    private WebElement password;

    @FindBy(xpath = "//span[contains(text(),'Đăng nhập')]")
    private WebElement login;

    @FindBys(@FindBy(tagName = "form"))
    @CacheLookup
    private WebElement form;

    @FindBys(@FindBy(tagName = "a"))
    @CacheLookup
    private List<WebElement> formlist;

    @FindBy(css = "a[href='work']")
    @CacheLookup
    public WebElement navigation_works;

    @FindBy(css = "div[class='control is-expanded'] i[class='material-icons-outlined is-size-6']")
    public WebElement add_user;

    @FindBy(id = "search_member")
    private WebElement search_member;

    @FindBy(xpath = "(//a[@class='icon is-small has-text-info'])[1]")
    private WebElement chose_user;

    @FindBy(css = "a[class='button is-link is-small'] span[class='is-size-7']")
    private WebElement done_user;

    @FindBys(@FindBy(id = "notify"))
    private List<WebElement> notify;

    @FindBy(css = "div[class='column is-narrow']")
    public WebElement sidebar;

    @FindBy(how = How.CSS, using = "a[class='has-text-info']")
    private List<WebElement> listWorks;

    @FindBy(css = "a[class='button is-link is-small']")
    public WebElement btnComponent;

    @FindBy(xpath = "(//li[@class='column is-one-third'])[2]")
    private WebElement mnuTask;

    public indexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String tagline() {
        try {
            String validation = "";
            if (notify.size() > 0) {
                validation = notify.get(0).getText().strip();
                System.out.println("Notify: " + validation);
            }
            return validation;
        } catch (Exception e) {
            e.printStackTrace();
            return "Status: Tagline is not Displayed...";
        }
    }

    public void login() {
        try {
            username.sendKeys("ndtruong.conando@gmail.com");
            Thread.sleep(1000);
            password.sendKeys("dantruong2410");
            Thread.sleep(1000);
            login.click();
            waitForPageLoaded();
            chose_corp();
            waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean verifyTitle(String nameTitle) {
        try {
            return getTitle().equals(nameTitle);
        } catch (Exception e) {
            System.out.println("Status: Title is wrong...");
            e.printStackTrace();
            return false;
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void chose_corp() {
        for (WebElement row : formlist) {
            String list_company = row.getText().strip();
            if (list_company.equals("Do Corp")) {
                row.click();
                break;
            }
        }
    }

    public void error_titlePage() {
        System.out.println("Status: FAILED...Title is wrong...");
        driver.close();
    }

    public void failed() {
        System.out.println("Status: FAILED");
        System.out.println("====================");
    }

    public void passed() {
        System.out.println("Status: PASSED");
        System.out.println("====================");
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

    public void choseWorks(String condition) {
        try {
            for (WebElement row : listWorks) {
                String nameWorks = row.getText().strip();
                if (nameWorks.equals(condition)) {
                    row.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigationTo_Plan() {
        try {
            login();
            sidebar.click();
            Thread.sleep(2000);
            navigation_works.click();
            waitForPageLoaded();
            choseWorks("fWorks: Prepare for Testing Mobile");
            waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigationTo_Task() {
        try {
            login();
            sidebar.click();
            Thread.sleep(2000);
            navigation_works.click();
            waitForPageLoaded();
            choseWorks("fWorks: Prepare for Testing Mobile");
            waitForPageLoaded();
            mnuTask.click();
            waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
