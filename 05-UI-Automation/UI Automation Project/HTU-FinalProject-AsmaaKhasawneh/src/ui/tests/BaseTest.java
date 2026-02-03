package ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUpDriver() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
