package testcase.Task;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.Task.TaskPage;
import setup.baseSetup;

public class createTaskTest {
    int testcase;
    String title;

    public createTaskTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {

            createTaskTest[] data = {
                    new createTaskTest(1, ""),
                    new createTaskTest(2, "Thực thi automation đạt chuẩn"),
            };
            
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            TaskPage task = new TaskPage(driver);

            index.navigationTo_Task();

            task.navigationFormTask();

            for (int i = 0; i < data.length; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + data[i].testcase);
                task.createTask(data[i].title);
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {
                    case "Bạn chưa nhập tiêu đề nhóm công việc!":
                        System.out.println(noti);
                        index.passed();
                        break;
                    default:
                        noti = index.tagline();
                        if (noti.equals("Đã thêm nhóm công việc!")) {
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
