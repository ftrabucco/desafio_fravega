package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FravegaResultsPage extends BasePage{

    public FravegaResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//h4[contains(text(),\"Heladeras\")][1]")
    WebElement filter_heladeras;

    @FindBy(name="viewAllBrands")
    WebElement ver_todas_option;

    @FindBy(xpath="//label[@for=\"filterItemsamsung\"]")
    WebElement samsung_option;

    @FindBy(id="apply")
    WebElement btn_aplicar;

    /**
     * Method does a click on 'Heladera' filter
     * */
    public void selectHeladerasOnLeftMenu(){
        click(filter_heladeras,5);
    }

    /**
     * Method does a click on link "ver todas"
     * */
    public void clickOnViewAll(){
        click(ver_todas_option,5);
    }

    /**
     * Method does a click on the samsung label option and then does a click on apply button
     * @return FravegaFilteredResultsPage
     * */
    public FravegaFilteredResultsPage clickOnSamsungFilter(){
        click(samsung_option,10);
        click(btn_aplicar);
        return new FravegaFilteredResultsPage(getDriver());
    }

}
