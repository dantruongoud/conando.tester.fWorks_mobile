package testcase.Comments;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.indexPage;
import page.Comments.commentPage;
import setup.baseSetup;

public class commentsTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            commentPage cmt = new commentPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("comments");
            cmt.navigationToComment();

            for (int i = 1; i < 3; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + excel.getCellData("TCID", i));
                cmt.setContentComments(excel.getCellData("content", i));
                Thread.sleep(1200);

                String noti = index.tagline();
                switch (noti) {
                    case "Bạn chưa nhập nội dung bình luận!":
                        System.out.println(noti);
                        index.passed();
                        break;
                    default:
                        if (cmt.verifyCmt("Cho bình luận phát nha")) {
                            index.passed();
                        } else {
                            System.out.println(noti);
                            index.failed();
                        }
                        break;
                }
                Thread.sleep(1500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
