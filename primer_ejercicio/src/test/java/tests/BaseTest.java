package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    WebDriver driver;
    public BaseTest(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chrome-driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void setUp(){
        driver.manage().window().maximize();
        driver.get("https://www.fravega.com");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
