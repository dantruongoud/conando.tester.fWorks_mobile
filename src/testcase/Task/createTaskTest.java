package testcase.Task;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.indexPage;
import page.Task.TaskPage;
import setup.baseSetup;

public class createTaskTest {
    

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            TaskPage task = new TaskPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Task");

            index.navigationTo_Task();

            task.navigationFormTask();

            for (int i = 1; i < 3; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + excel.getCellData("TCID", i));
                task.createTask(excel.getCellData("title", i));
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {
                    case "Bạn chưa nhập tiêu đề nhóm công việc!":
                        System.out.println(noti);
                        index.passed();
                        break;
                    default:
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
