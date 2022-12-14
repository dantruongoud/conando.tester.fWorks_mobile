package testcase.Plans;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Plans.createPlansPage;
import setup.baseSetup;

public class createPlansTest {

    int testcase;
    String title, description;

    public createPlansTest(int testcase, String title, String description) {
        this.testcase = testcase;
        this.title = title;
        this.description = description;
    }

    public static void main(String[] args) {
        try {

            createPlansTest[] data = {
                    new createPlansTest(1, "fWorks: Prepare for Testing", "Đây là dự án cực kỳ quan trọng"),
                    new createPlansTest(2, "", "Đây là dự án cực kỳ quan trọng"),
                    new createPlansTest(3, "fWorks: Prepare for Testing Mobile", "Đây là dự án cực kỳ quan trọng"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            createPlansPage plans = new createPlansPage(driver);

            index.login();

            index.sidebar.click();
            Thread.sleep(2000);

            index.navigation_works.click();
            index.waitForPageLoaded();

            plans.btnCreatePLan.click();
            Thread.sleep(1000);
            plans.removeUser();

            for (int i = 0; i < data.length; i++) {

                System.out.println("====================");

                System.out.println("Testcase: " + data[i].testcase);
                plans.txtTitlePlans.sendKeys(data[i].title);
                plans.txaDescription.sendKeys(data[i].description);
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
                        if (noti.equals("Đã tạo kế hoạch: fWorks: Prepare for Testing Mobile")) {
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
