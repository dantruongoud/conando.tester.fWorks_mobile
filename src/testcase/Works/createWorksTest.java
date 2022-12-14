package testcase.Works;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Works.worksPage;
import setup.baseSetup;

public class createWorksTest {

    int testcase;
    String title;

    public createWorksTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {

            createWorksTest[] data = {
                    new createWorksTest(1, "Lập plan để thực thi"),
                    // new createWorksTest(2, "Lập plan để thực thi"),
                    new createWorksTest(2, "Lập plan để thực thi"),
                    new createWorksTest(3, ""),
                    new createWorksTest(4, "Lập plan để thực thi"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            worksPage works = new worksPage(driver);

            index.navigationTo_Task();

            works.navigationFormWorks();

            works.removeUser();

            for (int i = 0; i < data.length; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + data[i].testcase);
                works.createWorks(data[i].title);
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {
                    case "Chọn người tham gia của công việc.":
                        System.out.println(noti);
                        index.passed();
                        index.add_user.click();
                        works.choseMember("truong");
                        works.txtTaskname.clear();
                        break;
                    case "Nhập thời gian thực hiện của công việc.":
                        System.out.println(noti);
                        index.passed();
                        works.sendKeysDay();
                        works.txtTaskname.clear();
                        break;
                    case "Chọn nhóm của công việc.":
                        System.out.println(noti);
                        index.passed();
                        works.choseTask();
                        works.txtTaskname.clear();
                        break;
                    // case "Ngày bắt đầu đang lớn hơn ngày kết thúc!":
                    // break;
                    // case "Ngày kết thúc đang nhỏ hơn ngày bắt đầu":
                    // break;
                    case "Nhập tiêu đề của công việc":
                        System.out.println(noti);
                        index.passed();
                        break;
                    default:
                        noti = index.tagline();
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
