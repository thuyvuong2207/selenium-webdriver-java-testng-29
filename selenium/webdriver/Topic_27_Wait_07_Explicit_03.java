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

public class Topic_27_Wait_07_Explicit_03 {
    WebDriver driver;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");
    String filename1 = "file1.png";
    String filename2 = "file2.png";

    String filePath1 = projectPath + File.separator + "uploadFiles" + File.separator + filename1;
    String filePath2 = projectPath + File.separator + "uploadFiles" + File.separator + filename2;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Ajax_loading() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "No Selected Dates to display.");

        driver.findElement(By.cssSelector("td[title*='Wednesday, May 22']")).click();
        // Wait until loading icon disappears
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));

        Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "Wednesday, May 22, 2024");
    }

    @Test
    public void TC_02_Upload_File() {
        driver.get("https://gofile.io/welcome");
        // Wait + Verify icon loading disappears
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));
        // Wait + Click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ajaxLink>button"))).click();

        // Wait + Verify all icon loading disappears
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));

        // Upload files
        driver.findElement(By.cssSelector("input#filesUploadInput")).sendKeys(filePath1 + "\n" + filePath2 + "\n");

        // Wait all progress bars disappears
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress")))));

        driver.findElement(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink")).click();

        // Wait + Verify button Download, Play display on each upload
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + filename1 + "']/parent::a/parent::div/following-sibling::div[contains(@class,'text-md-end')]//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + filename2 + "']/parent::a/parent::div/following-sibling::div[contains(@class,'text-md-end')]//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + filename1 + "']/parent::a/parent::div/following-sibling::div[contains(@class,'text-md-end')]//span[text()='Play']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + filename2 + "']/parent::a/parent::div/following-sibling::div[contains(@class,'text-md-end')]//span[text()='Play']"))).isDisplayed());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}