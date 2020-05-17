package lab5_vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://hackme.pricope-stefan.com/index.php")
public class HackmePage extends PageObject {
    @FindBy(linkText="Login/Register")
    private WebElementFacade loginHyperlink;
    @FindBy(name = "username")
    private WebElementFacade usernameInput;
    @FindBy(name = "password")
    private WebElementFacade passwordInput;
    @FindBy(linkText = "Logout")
    private WebElementFacade logoutHyperlink;

    public void login() {
        loginHyperlink.click();
    }

    public void addUser (String username, String password) {
        usernameInput.typeAndTab(username);
        passwordInput.typeAndEnter(password);
    }

    public void logout() {
        logoutHyperlink.click();
    }
}