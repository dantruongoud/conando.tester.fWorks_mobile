package testcase.History;

import org.openqa.selenium.WebDriver;

import page.indexPage;
import page.History.historyPlansPage;
import page.Works.subWorksPage;
import setup.baseSetup;

public class historyWorksTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            indexPage index = new indexPage(driver);
            historyPlansPage history = new historyPlansPage(driver);
            subWorksPage subworks = new subWorksPage(driver);

            index.navigationTo_Task();
            subworks.choseWorks.click();

            history.navigation_history.click();
            index.waitForPageLoaded();

            history.getTitleTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
