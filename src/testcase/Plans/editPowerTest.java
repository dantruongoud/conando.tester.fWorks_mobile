package testcase.Plans;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Plans.editPowerPage;
import setup.baseSetup;

public class editPowerTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            editPowerPage edit = new editPowerPage(driver);

            index.navigationTo_Plan();
            edit.addUser.click();
            Thread.sleep(1000);
            edit.getUser.click();
            Thread.sleep(1000);
            edit.chosePower.click();
            Thread.sleep(1000);
            edit.savePower.click();

            String noti = index.tagline();
            if (noti.equals("Bạn không thể xóa hết quản lý của kế hoạch.")) {
                index.passed();
            } else {
                index.failed();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
