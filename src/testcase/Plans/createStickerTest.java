package testcase.Plans;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Plans.createStickerPage;
import setup.baseSetup;

public class createStickerTest {

    int testcase;
    String title;

    public createStickerTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {

            createStickerTest[] data = {
                    new createStickerTest(1, ""),
                    new createStickerTest(2, "Hằng tháng"),
            };
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            createStickerPage sticker = new createStickerPage(driver);

            index.navigationTo_Plan();
            for (int i = 0; i < data.length; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + data[i].testcase);
                sticker.createSticker(data[i].title);
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {
                    case "Bạn chưa nhập tiêu đề nhãn.":
                        System.out.println(noti);
                        index.passed();
                        break;
                    default:
                        noti = index.tagline();
                        if (noti.equals("Đã cập nhật nhãn công việc.")) {
                            System.out.println(noti);
                            index.passed();
                        } else {
                            System.out.println(noti);
                            index.failed();
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
