package lab5_vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://hackme.pricope-stefan.com/index.php?page=html5-storage.php")
public class HackmeStoragePage extends PageObject {
    @FindBy(id = "idDOMStorageKeyInput") private WebElementFacade keyInput;
    @FindBy(id = "idDOMStorageItemInput") private WebElementFacade valueInput;
    @FindBy(xpath = "//input[@type='radio' and @value='Local']") private WebElementFacade typeRadioLocal;
    @FindBy(xpath = "//input[@type='button' and @value='Add New']") private WebElementFacade addButton;
    private Select dropdown;

    public void enterData(String key, String value) {
        keyInput.type(key);
        valueInput.type(value);
        typeRadioLocal.click();
        addButton.click();
    }

    public List<String> getStorageTable() {
        WebElementFacade entriesTableBody = find(By.id("idSessionStorageTableBody"));
        return entriesTableBody.findElements(By.tagName("tr")).stream()
                .map( element -> {
                    String pair_key = element.findElements(By.tagName(("td"))).get(0).getText();
                    String pair_value = element.findElements(By.tagName(("td"))).get(1).getText();
                    return "" + pair_key.toString() + ":" + pair_value.toString();
                })
                .collect(Collectors.toList());
    }
}
