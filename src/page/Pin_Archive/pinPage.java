package page.Pin_Archive;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pinPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'scrolly px-3 pb-5')]//div[contains(@class,'icon-text')]")
    private List<WebElement> listplans;

    @FindBy(xpath = "//div[@class='dropdown-menu is-size-7']//div[@class='dropdown-content']//a[2]")
    private WebElement pinPlans;

    @FindBy(xpath = "//div[@class='dropdown-menu is-size-7']//div[@class='dropdown-content']//a[3]")
    private WebElement archive;

    @FindBy(xpath = "//div[@class='scrolly px-3 pb-5']/div[1]")
    public WebElement displayPLansPin;

    @FindBy(xpath = "(//a[@class='icon-text is-fullwidth'])[2]")
    private WebElement titlePLansPin;

    public pinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void choseWorks() {
        try {
            for (int i = 0; i < listplans.size(); i++) {
                if (listplans.size() > 0) {
                    WebElement plans1 = listplans.get(0).findElement(By.tagName("div"));
                    plans1.click();
                    Thread.sleep(1000);
                    pinPlans.click();
                    Thread.sleep(500);
                    Alert alert = driver.switchTo().alert();
                    System.out.println(alert.getText().strip());
                    alert.accept();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyPlansPin() {
        try {
            if (displayPLansPin.isDisplayed()) {
                System.out.println(
                        titlePLansPin.findElement(By.cssSelector(".is-size-7.has-text-weight-semibold")).getText()
                                .strip());
                System.out.println(displayPLansPin.findElement(By.tagName("a")).getAttribute("title"));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void archivePlans() {
        try {
            for (int i = 0; i < listplans.size(); i++) {
                if (listplans.size() > 0) {
                    WebElement plans1 = listplans.get(0).findElement(By.tagName("div"));
                    plans1.click();
                    Thread.sleep(1000);
                    archive.click();
                    Thread.sleep(500);
                    Alert alert = driver.switchTo().alert();
                    System.out.println(alert.getText().strip());
                    alert.accept();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
