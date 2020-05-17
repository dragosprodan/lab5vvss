package lab5_vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

        import java.util.List;
        import java.util.stream.Collectors;

@DefaultUrl("https://hackme.pricope-stefan.com/index.php?page=source-viewer.php")
public class HackmeScrollerPage extends PageObject {
    @FindBy(id = "id_file_select")
    private WebElementFacade dropdownFiles;
    @FindBy(name = "source-file-viewer-php-submit-button")
    private WebElementFacade submitButton;

    public List<String> getFiles() {
        System.out.println("SIZE = " + dropdownFiles.findElements(By.tagName("option")).size());
        return dropdownFiles.findElements(By.tagName("option")).stream().map( element -> element.getText()).collect(Collectors.toList());
    }

    public void viewSource(String file) {
        Select drpCountry = new Select(dropdownFiles);
        drpCountry.selectByVisibleText(file);
        submitButton.click();
    }
}
