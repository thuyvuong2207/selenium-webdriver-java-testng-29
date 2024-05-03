package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_Wait_01 {
    WebDriver driver;
    WebDriverWait explicitWait;
    By reconfirmEmailTextbox = By.cssSelector("input[name='reg_email_confirmation__']");

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        // Init explicit wait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void TC_01_Visible() {
        // #1 - Element in both UI and DOM
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSeconds(5);

        // Explicit wait when the element is visible
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("thuyvm@gmail.com");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextbox));

        // Assert if the element is visible on UI
        Assert.assertTrue(driver.findElement(reconfirmEmailTextbox).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_In_DOM() {
        // #2 - Element not in UI, but in DOM
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSeconds(5);

        // Clear email input
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSeconds(3);

        // Explicit wait when element is invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        // Assert if the element is invisible on UI
        Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_Not_In_DOM() {
        // #3 - Element not in UI nor in DOM
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSeconds(5);

        // Close popup
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling:: img")).click();
        sleepInSeconds(3);

        // Explicit wait when element is invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        // Assert if the element is invisible on UI
        Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());
    }

    @Test
    public void TC_03_Presence() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSeconds(5);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("thuyvm@gmail.com");
        sleepInSeconds(3);

        // Explicit wait when the element is on UI and on DOM (condition 1) > presence
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));

        // Explicit wait when the element is not on UI but still on DOM (condition 2) > presence
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSeconds(3);
    }

    @Test
    public void TC_04_Staleness() {
        // #3 - Element not in UI nor in DOM
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSeconds(5);

        WebElement reconfirmEmail = driver.findElement(reconfirmEmailTextbox);

        // Close popup
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling:: img")).click();
        sleepInSeconds(3);

        // Explicit wait when element is invisible
        explicitWait.until(ExpectedConditions.stalenessOf(reconfirmEmail));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}