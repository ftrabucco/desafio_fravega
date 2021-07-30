package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumutils.Waits;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FravegaFilteredResultsPage extends BasePage{

    public FravegaFilteredResultsPage(WebDriver driver) {
        super(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(css=".generalstyles__Column-sc-1j7wv79-5 .PieceLayout__ResponsiveLayout-orsj2a-3 .PieceDetails-sc-1sszgtb-0 .PieceTitle-sc-1eg7yvt-0")
    List<WebElement> titles_results;

    @FindBy(xpath="//li[@name='totalResult'] /span")
    WebElement total_results;

    /**
     * Method validates if all results contain the searched text
     * @param text contained
     * @return boolean : true if values contain the word otherwise is false
     * */
    public boolean areAllTitlesResultsContained(String text){
        Waits.waitForElementToBeVisible(driver,titles_results.get(0),15);
        Waits.waitForElementToBeClickable(titles_results.get(0));
        return titles_results
                .stream()
                .allMatch(element ->element.getText().contains(text));
    }

    /**
     * Method compares if the value displayed on the left menu is equal to the
     * amount of products showed
     * @return boolean : true if values are equals otherwise is false.
     * */
    public boolean areAllResultsDisplayed(){
        return titles_results.size() == Integer.parseInt(total_results.getText());
    }

}
