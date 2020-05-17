package lab5_vvss.features.search;

import lab5_vvss.steps.serenity.UserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class HackmeScenarioStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public UserSteps uSteps;

    @Test
    public void scenario_add_pair_web_storage() {
        //1 login
        uSteps.toHomepage();
        uSteps.toLogin();
        //connect to server
        uSteps.enterData("admin", "adminpass");
        //test
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assert uSteps.logoutExists();
        assert uSteps.cookieTest("username");

        //2 add data
        uSteps.toStorage();
        //verify data existence
        List<String> entries = uSteps.getStorageData();
        assert entries.size() > 0;
        //add new data
        uSteps.enterStorageData("test", "test");
        List<String> newEntries = uSteps.getStorageData();
        //verify new data
        assert newEntries.size() == entries.size() + 1;
        assert newEntries.get(newEntries.size() - 1).equals("test:test");

        //3 use scroller
        uSteps.toScroller();
        uSteps.viewScroller("pen-test-tool-lookup-ajax.php");
        // test data
        System.out.println("test:");
        List<String> showedData = uSteps.getScrollerFiles();
        assert showedData.get(0).equals("pen-test-tool-lookup-ajax.php");

        //4 logout
        uSteps.logout();
        //verify logout
        assert !uSteps.cookieTest("username");
    }
}
