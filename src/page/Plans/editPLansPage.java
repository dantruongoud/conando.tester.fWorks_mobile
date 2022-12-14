package page.Plans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editPLansPage {

    WebDriver driver;

    @FindBy(css = "li[class='column is-one-fifth-tablet is-one-third-mobile has-text-right'] a[class='icon-text has-text-link']")
    public WebElement btnEditPlans;

    public editPLansPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
