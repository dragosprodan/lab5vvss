package lab5_vvss.steps.serenity;

import lab5_vvss.pages.HackmePage;
import lab5_vvss.pages.HackmeStoragePage;
import lab5_vvss.pages.HackmeScrollerPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;

public class UserSteps {
    HackmePage homePage;
    HackmeStoragePage storagePage;
    HackmeScrollerPage scrollPage;

    @Step
    public void toHomepage() {
        homePage.open();
    }

    @Step
    public void toLogin() {
        homePage.login();
    }

    @Step
    public void enterData(String username, String password) {
        homePage.addUser(username, password);
    }

    @Step
    public boolean cookieTest(String cookie_key) {
        return homePage.getDriver().manage().getCookieNamed(cookie_key) != null;
    }

    @Step
    public boolean logoutExists() {
        System.out.println("LOGOUT ELEMENT COUNT = " + homePage.getDriver().findElements(By.linkText("Logout")).isEmpty());
        return !homePage.getDriver().findElements( By.linkText("Logout") ).isEmpty();
    }

    @Step
    public void logout() {
        homePage.logout();
    }

    @Step
    public void toStorage() {
        storagePage.open();
    }

    @Step
    public void enterStorageData(String key, String value) {
        storagePage.enterData(key, value);
    }

    @Step
    public List<String> getStorageData() {
        return storagePage.getStorageTable();
    }

    @Step
    public void toScroller() {
        scrollPage.open();
    }
    @Step
    public List<String> getScrollerFiles() {
        return scrollPage.getFiles();
    }

    @Step
    public void viewScroller(String file) {
        scrollPage.viewSource(file);
    }
}
