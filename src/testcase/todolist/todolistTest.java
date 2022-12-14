package testcase.todolist;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.todolist.todolistPage;
import setup.baseSetup;

public class todolistTest {

    int testcase;
    String text, star, end;

    public todolistTest(int testcase, String text, String star, String end) {
        this.testcase = testcase;
        this.text = text;
        this.star = star;
        this.end = end;
    }

    public static void main(String[] args) {
        try {

            todolistTest[] data = {
                    new todolistTest(1, "Title", "", ""),
                    new todolistTest(2, "Title", "5120020223331", "7120020223332"),
                    new todolistTest(3, "Title", "612", "512"),
                    new todolistTest(4, "", "1012", "1212"),
                    new todolistTest(5, "Hoàn thành 3 bài tập mỗi ngày", "1012", "1212")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            todolistPage todolist = new todolistPage(driver);

            todolist.navigationTodolist();

            for (int i = 0; i < data.length; i++) {
                System.out.println("====================");

                System.out.println("Testcase: " + data[i].testcase);
                todolist.setText(data[i].text, data[i].star, data[i].end);
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
