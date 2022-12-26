package testcase.Plans;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.indexPage;
import page.Plans.createPlansPage;
import setup.baseSetup;

public class createPlansTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            createPlansPage plans = new createPlansPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Create Plan");

            index.login();

            index.sidebar.click();
            Thread.sleep(2000);

            index.navigation_works.click();
            index.waitForPageLoaded();

            plans.btnCreatePLan.click();
            Thread.sleep(1000);
            plans.removeUser();

            for (int i = 1; i < 4; i++) {

                System.out.println("====================");

                System.out.println("Testcase: " + excel.getCellData("TCID", i));
                plans.txtTitlePlans.sendKeys(excel.getCellData("title", i));
                plans.txaDescription.sendKeys(excel.getCellData("description", i));
                plans.btnDone_plans.click();
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {

                    case "Kế hoạch chưa có thành viên.":
                        System.out.println(noti);
                        index.passed();
                        index.add_user.click();
                        plans.choseMember("truong");
                        plans.txtClear();
                        break;

                    case "Bạn chưa nhập tiêu đề kế hoạch.":
                        System.out.println(noti);
                        index.passed();
                        plans.txtClear();
                        break;

                    default:
                        noti = index.tagline();
                        if (noti.equals("Đã tạo kế hoạch: " + excel.getCellData("title", 3))) {
                            System.out.println(noti);
                            index.passed();
                        } else {
                            System.out.println(noti);
                            index.failed();
                        }
                        break;
                }
                Thread.sleep(1000);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
