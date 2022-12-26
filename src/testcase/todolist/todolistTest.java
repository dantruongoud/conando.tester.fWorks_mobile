package testcase.todolist;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.indexPage;
import page.todolist.todolistPage;
import setup.baseSetup;

public class todolistTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            todolistPage todolist = new todolistPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("todolist");

            todolist.navigationTodolist();

            for (int i = 1; i < 6; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + excel.getCellData("TCID", i));
                todolist.setText(excel.getCellData("text", i), excel.getCellData("star", i),
                        excel.getCellData("end", i));
                Thread.sleep(1000);

                String noti = index.tagline();
                switch (noti) {
                    case "Nhập tiêu đề của Todolist":
                        index.passed();
                        break;
                    case "Chọn ngày tạo Todolist":
                        index.passed();
                        todolist.txtTaskTodo.clear();
                        break;
                    case "Vui lòng chọn lại ngày bắt đầu":
                        index.passed();
                        todolist.txtTaskTodo.clear();
                        break;
                    case "Vui lòng chọn lại thời gian phù hợp":
                        index.passed();
                        todolist.txtTaskTodo.clear();
                        break;
                    default:
                        if (noti.equals("Đã tạo Todolist liên kết với công việc")) {
                            index.passed();
                        } else {
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
