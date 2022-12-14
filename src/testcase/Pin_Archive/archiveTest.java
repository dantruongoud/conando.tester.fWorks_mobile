package testcase.Pin_Archive;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Pin_Archive.pinPage;
import setup.baseSetup;

public class archiveTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            pinPage pin = new pinPage(driver);

            index.login();

            index.sidebar.click();
            Thread.sleep(2000);

            index.navigation_works.click();
            index.waitForPageLoaded();

            pin.archivePlans();

            System.out.println("====================");
            System.out.println("Testcase 1");
            String noti = index.tagline();
            if (noti != null) {
                index.passed();

            } else {
                index.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
