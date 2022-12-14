package setup;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import page.indexPage;

public class baseSetup {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    // Khởi tạo cấu hình của các Browser
    public WebDriver initChromeDriver() throws IOException {

        indexPage index = new indexPage(driver);

        // Config user agent
        ChromeOptions userAgent = new ChromeOptions();

        // Disable notifications
        userAgent.addArguments("disable-notifications");

        // Disable user agent default
        // userAgent.addArguments(
        // "user-agent=\"Mozilla/5.0 (iPhone; CPU iPhone OS 13_2 like Mac OS X)
        // AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/107.0.0.0 Mobile/15E148
        // Safari/604.1\"");

        // Set thiết bị
        userAgent.setExperimentalOption("mobileEmulation", Map.of("deviceName",
                "iPhone 6/7/8 Plus"));

        // Khởi tạo driver từ ChromeDriver đã config user agent
        driver = new ChromeDriver(userAgent);

        // Điều hướng url
        System.out.println("Launching Chrome browser...");
        driver.get("https://beta.fastdo.vn/");

        // Set timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        index.waitForPageLoaded();

        return driver;
    }
}
