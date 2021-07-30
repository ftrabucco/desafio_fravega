package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumutils.Waits;

public class FravegaBasePage extends BasePage{

    public FravegaBasePage(WebDriver driver) {
        super(driver);
        closeModal();
    }

    @FindBy(css=".sc-jJMGnK")
    WebElement close_modal_btn;

    @FindBy(name="keyword")
    WebElement search_box;

    @FindBy(id="react-aria-modal-dialog")
    WebElement modal;

    /**
     * Method closes the fravega modal
     * */
    public void closeModal(){
        Waits.waitForElementToBeVisible(driver,modal,5);
        click(close_modal_btn,5);
    }

    /**
     *Method writes the searched product on searchbox and press
     * enter for submit the search
     * @param product searched
     * @return FravegaResultsPage
     * */
    public FravegaResultsPage getProductPage(String product){
        Waits.waitForElementToBeVisible(driver,search_box,5);
        search_box.clear();
        search_box.sendKeys(product);
        search_box.sendKeys(Keys.ENTER);
        return new FravegaResultsPage(driver);
    }
}
