package testcase.History;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.History.historyPlansPage;
import setup.baseSetup;

public class historyPlansTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            historyPlansPage history = new historyPlansPage(driver);

            index.navigationTo_Plan();

            history.getTitleTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
