package testcase.Works;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.indexPage;
import page.Works.worksPage;
import setup.baseSetup;

public class createWorksTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            worksPage works = new worksPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Works");

            index.navigationTo_Task();

            works.navigationFormWorks();

            works.removeUser();

            for (int i = 1; i < 5; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + excel.getCellData("TCID", i));
                works.createWorks(excel.getCellData("title", i));
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {
                    case "Chọn người tham gia của công việc!":
                        System.out.println(noti);
                        index.passed();
                        index.add_user.click();
                        works.choseMember("truong");
                        works.txtTaskname.clear();
                        break;
                    case "Nhập thời gian thực hiện của công việc!":
                        System.out.println(noti);
                        index.passed();
                        works.sendKeysDay();
                        works.txtTaskname.clear();
                        break;
                    case "Chưa chọn nhóm của công việc!":
                        System.out.println(noti);
                        index.passed();
                        works.choseTask();
                        works.txtTaskname.clear();
                        break;
                    // case "Ngày bắt đầu đang lớn hơn ngày kết thúc!":
                    // break;
                    // case "Ngày kết thúc đang nhỏ hơn ngày bắt đầu":
                    // break;
                    case "Nhập tiêu đề của công việc!":
                        System.out.println(noti);
                        index.passed();
                        break;
                    default:
                        if (noti.equals("Đã tạo công việc thành công!")) {
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
