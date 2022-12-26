package testcase.Plans;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.indexPage;
import page.Plans.createPlansPage;
import page.Plans.editPLansPage;
import setup.baseSetup;

public class editPlansTest {
    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            createPlansPage createPlans = new createPlansPage(driver);
            editPLansPage editPlans = new editPLansPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Create Plan");

            index.navigationTo_Plan();
            editPlans.btnEditPlans.click();
            Thread.sleep(2000);
            createPlans.txtClear();

            for (int i = 2; i < 4; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + excel.getCellData("TCID", i));
                createPlans.txtTitlePlans.sendKeys(excel.getCellData("title", i));
                createPlans.txaDescription.sendKeys(excel.getCellData("description", i));
                index.btnComponent.click();
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {
                    case "Bạn chưa nhập tiêu đề kế hoạch!":
                        System.out.println(noti);
                        index.passed();
                        createPlans.txtClear();
                        break;
                    default:
                        if (noti.equals("Đã cập nhật thông tin của dự án.")) {
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
