package testcase.Works;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.indexPage;
import page.Works.subWorksPage;
import page.Works.worksPage;
import setup.baseSetup;

public class subWorksTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            subWorksPage subWorks = new subWorksPage(driver);
            worksPage works = new worksPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("subWorks");

            index.navigationTo_Task();

            subWorks.navigationTo_SubWorks();

            for (int i = 1; i < 4; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + excel.getCellData("TCID", i));
                subWorks.setText(excel.getCellData("title", i), excel.getCellData("description", i));
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {
                    case "Nhập tiêu đề của công việc":
                        index.passed();
                        subWorks.clear();
                        break;
                    // case "Nhập thời gian thực hiện của công việc.":
                    // subWorks.choseTime();
                    // index.passed();
                    // subWorks.clear();
                    // break;
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
