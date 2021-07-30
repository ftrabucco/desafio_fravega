package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import seleniumutils.Waits;


public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element){
        Waits.waitForElementToBeClickable(element);
        element.click();
    }

    public void click(WebElement element,int timeout){
        Waits.waitForElementToBeVisible(this.driver,element,timeout);
        element.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
