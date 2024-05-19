package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Date;

public class Topic_29_Wait_08_Mix_Explicit_Implicit {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Implicit_Only_Found() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com");
        driver.findElement(By.cssSelector("input#email"));
    }
    @Test
    public void TC_02_Implicit_Only_NotFound() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com");
        driver.findElement(By.cssSelector("input#random"));
        // Search until timeout.
        // Polling every 500ms
        // Fail TC and throw exception NoSuchElementException
    }

    @Test
    public void TC_03_Explicit_Only_Found() {
       driver.get("https://www.facebook.com");
       explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
       explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
    }

    @Test
    public void TC_04_Explicit_Only_NotFound_Param_By() {
        driver.get("https://www.facebook.com");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#random")));
        // Search until timeout.
        // Polling every 500ms
        // Fail TC and throw exception TimeOutException
        // TimeOutException: Expected condition failed: waiting for visibility of element located by By.cssSelector: input#random (tried for 5 second(s) with 500 milliseconds interval)
    }

    @Test
    public void TC_04_Explicit_Only_NotFound_Param_WebElement() {
        driver.get("https://www.facebook.com");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("Start time: " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#random"))));
        } catch (Exception e) {
            System.out.println("End time: " + getDateTimeNow());
            e.printStackTrace();
        }
        // Search until timeout.
        // Polling every 500ms
        // Fail TC and throw exception NoSuchElementException
    }

    @Test
    public void TC_05_Mix_Found() {
        driver.get("https://www.facebook.com");
        driver.manage ().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        System.out.println("Start time: " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#random")));
        } catch (Exception e) {
            System.out.println("End time: " + getDateTimeNow());
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }
}