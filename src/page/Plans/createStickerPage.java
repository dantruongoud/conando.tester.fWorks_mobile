package page.Plans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createStickerPage {
    WebDriver driver;

    @FindBy(css = "a[class='button is-link']")
    private WebElement btncreateSticker;

    @FindBy(xpath = "//input[@placeholder='Nhập tiêu đề nhãn']")
    private WebElement txtTitleSticker;

    public createStickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createSticker(String title) {
        try {
            txtTitleSticker.sendKeys(title);
            btncreateSticker.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
