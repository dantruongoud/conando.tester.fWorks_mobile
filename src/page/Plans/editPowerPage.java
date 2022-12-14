package page.Plans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editPowerPage {
    WebDriver driver;

    @FindBy(xpath = "(//i[@class='material-icons-outlined is-size-6'][normalize-space()='add'])[1]")
    public WebElement addUser;

    @FindBy(xpath = "//span[contains(text(),'Quản lý')]")
    public WebElement getUser;

    @FindBy(xpath = "(//a[contains(text(),'Thành viên')])[1]")
    public WebElement chosePower;

    @FindBy(xpath = "//a[contains(@class,'button is-link is-small')]")
    public WebElement savePower;

    public editPowerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
