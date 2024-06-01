package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.Assert;


public class Topic_03_Assert {
    WebDriver driver;
    @Test
    public void TC_01_() {
        // Equals
        String fullname = "Automation FC";
        Assert.assertEquals(fullname, "Automation FC");

        // True False
        Assert.assertTrue(isElementDisplayed(By.xpath("")));
        Assert.assertTrue(isElementDisplayed(By.xpath("")), "Alert message displayed");

    }

    private boolean isElementDisplayed (By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}
