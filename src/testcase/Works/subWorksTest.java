package testcase.Works;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Works.subWorksPage;
import page.Works.worksPage;
import setup.baseSetup;

public class subWorksTest {
    int testcase;
    String title, description;

    public subWorksTest(int testcase, String title, String description) {
        this.testcase = testcase;
        this.title = title;
        this.description = description;
    }

    public static void main(String[] args) {
        try {

            subWorksTest[] data = {
                    new subWorksTest(1, "", "Đây là công việc phụ vô cùng quan trọng"),
                    new subWorksTest(2, "Công việc phụ số 1", "Đây là công việc phụ vô cùng quan trọng"),
                    new subWorksTest(3, "Công việc phụ số 1", "Đây là công việc phụ vô cùng quan trọng"),
                    new subWorksTest(4, "Công việc phụ số 1", "Đây là công việc phụ vô cùng quan trọng"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            subWorksPage subWorks = new subWorksPage(driver);
            worksPage works = new worksPage(driver);

            index.navigationTo_Task();

            subWorks.navigationTo_SubWorks();

            for (int i = 0; i < data.length; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + data[i].testcase);
                subWorks.setText(data[i].title, data[i].description);
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {
                    case "Nhập tiêu đề của công việc":
                        index.passed();
                        subWorks.clear();
                        break;
                    case "Nhập thời gian thực hiện của công việc.":
                        subWorks.choseTime();
                        index.passed();
                        subWorks.clear();
                        break;
                    case "Chọn người tham gia của công việc.":
                        subWorks.btnAddUser.click();
                        works.choseMember("truong");
                        index.passed();
                        subWorks.clear();
                        break;
                    default:
                        if (subWorks.verifyListSubWorks("Công việc phụ số 1")) {
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
