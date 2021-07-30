package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FravegaBasePage;
import pages.FravegaFilteredResultsPage;
import pages.FravegaResultsPage;

public class FirstTest extends BaseTest{

    @Test(description="first test")
    public void fravega_test_one() throws InterruptedException {
        FravegaBasePage fravegaBasePage = new FravegaBasePage(driver);
        FravegaResultsPage fravegaResultsPage = fravegaBasePage.getProductPage("Heladera");
        fravegaResultsPage.selectHeladerasOnLeftMenu();
        fravegaResultsPage.clickOnViewAll();
        FravegaFilteredResultsPage fravegaFilteredResultsPage = fravegaResultsPage.clickOnSamsungFilter();
        Assert.assertTrue(fravegaFilteredResultsPage.areAllTitlesResultsContained("Samsung"),
                "the title of the product doesn't contains \"Samsung\" word");
        Assert.assertTrue(fravegaFilteredResultsPage.areAllResultsDisplayed(),
                "the number of results doesn't match");
    }
}
