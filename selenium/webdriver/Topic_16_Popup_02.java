package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class Topic_16_Popup_02 {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_05_Random_Popup_Not_In_DOM() {
        driver.get("https://www.javacodegeeks.com/");
        sleepInSeconds(10);
        By newsletterPopUp = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");

        // If displayed , onclick Close button
        if (driver.findElements(newsletterPopUp).size() > 0 && driver.findElements(newsletterPopUp).get(0).isDisplayed()) {
            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']) div.lepopup-element-html-content a:not([class='lepopup-inherited lepopup-inherited'])"))
                    .click();
            sleepInSeconds(3);
        } else {
            System.out.println("No popup display");
        }

        // If not displayed, move to next step. Search for an article and onclick that article
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
    }

    @Test
    public void TC_06_Random_Popup_In_DOM() {
        driver.get("https://vnk.edu.vn/");
        sleepInSeconds(10);

        By marketingPopup = By.cssSelector("div.tve-leads-conversion-object");
        if (driver.findElement(marketingPopup).isDisplayed()){
            driver.findElement(By.cssSelector("div.thrv_wrapper.thrv_icon.tcb-icon-display")).click();
            sleepInSeconds(3);
            System.out.println("Popup displays");
        } else {
            System.out.println("Popup doesn't display");
        }

        driver.findElement(By.xpath("//button[text()='Danh sách khóa học']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.title-content>h1")).getText().toLowerCase(),"lịch khai giảng tháng 04");
    }

    @Test
    public void TC_07_Random_Popup_Not_In_DOM() {
        driver.get("https://dehieu.vn/");
        sleepInSeconds(10);
        By marketingPopup = By.cssSelector("div.popup-content");

        if (driver.findElements(marketingPopup).size() > 0 && driver.findElements(marketingPopup).get(0).isDisplayed()){
            System.out.println("Popup displays");

            int heightBrowser = driver.manage().window().getSize().getHeight();
            if (heightBrowser < 1920 ) {
                ((JavascriptExecutor) driver).executeScript( "arguments[0].click",driver.findElement(By.cssSelector("button#close-popup")));
            } else {
                driver.findElement(By.cssSelector("button#close-popup")).click();
            }
            sleepInSeconds(3);

        }

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