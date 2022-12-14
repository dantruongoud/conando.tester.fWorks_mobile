package testcase.Comments;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Comments.commentPage;
import setup.baseSetup;

public class commentsTest {

    int testcase;

    String content;

    public commentsTest(int testcase, String content) {
        this.testcase = testcase;
        this.content = content;
    }

    public static void main(String[] args) {
        try {

            commentsTest[] data = {
                    new commentsTest(1, ""),
                    new commentsTest(2, "Cho bình luận phát nha")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            commentPage cmt = new commentPage(driver);

            cmt.navigationToComment();

            for (int i = 0; i < data.length; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + data[i].testcase);
                cmt.setContentComments(data[i].content);
                Thread.sleep(1200);

                String noti = index.tagline();
                switch (noti) {
                    case "Bạn chưa nhập nội dung bình luận!":
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
