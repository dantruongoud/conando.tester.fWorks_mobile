package testcase.Pin_Archive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Pin_Archive.pinPage;
import setup.baseSetup;

public class pinTest {
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

            pin.choseWorks();

            System.out.println("====================");
            System.out.println("Testcase 1");
            String noti = index.tagline();
            if (noti.equals(
                    "Đã ghim kế hoạch " + pin.displayPLansPin.findElement(By.tagName("a")).getAttribute("title"))) {
                index.passed();

                System.out.println("====================");
                System.out.println("Testcase 2");
                if (pin.verifyPlansPin()) {
                    index.passed();
                } else {
                    index.failed();
                }

            } else {
                index.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
