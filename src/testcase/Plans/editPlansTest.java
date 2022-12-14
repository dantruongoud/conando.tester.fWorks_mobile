package testcase.Plans;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Plans.createPlansPage;
import page.Plans.editPLansPage;
import setup.baseSetup;

public class editPlansTest {
    public static void main(String[] args) {
        try {

            createPlansTest[] data = {
                    new createPlansTest(1, "", "Đây là dự án cực kỳ quan trọng"),
                    new createPlansTest(2, "fWorks: Prepare for Testing Mobile", "Đây là dự án cực kỳ quan trọng"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            createPlansPage createPlans = new createPlansPage(driver);
            editPLansPage editPlans = new editPLansPage(driver);

            index.navigationTo_Plan();
            editPlans.btnEditPlans.click();
            Thread.sleep(2000);
            createPlans.txtClear();

            for (int i = 0; i < data.length; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + data[i].testcase);
                createPlans.txtTitlePlans.sendKeys(data[i].title);
                createPlans.txaDescription.sendKeys(data[i].description);
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
                        noti = index.tagline();
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
