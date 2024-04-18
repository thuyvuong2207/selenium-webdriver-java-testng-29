package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_18_Window_Tab {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    @Test
    public void TC_13_Window_Tab() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);
        // Get ID of current window
        String basicFormID = driver.getWindowHandle();
        System.out.println("Current Window ID " + basicFormID);
        // Click to open next window
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSeconds(2);

        switchWindow(basicFormID);
        String GoogleID = driver.getWindowHandle();

        // Switch back to original window
        switchWindow(GoogleID);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSeconds(3);

        // Switch to window with title Facebook
        switchWindowByTitle("Facebook - log in or sign up");

        closeAllWindowsWithoutParent(basicFormID);
    }

    @Test
    public void TC_14_Window_Tab() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSeconds(3);

        driver.findElement(By.xpath("//a[@title='Xperia']/following-sibling::div//div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),"The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/following-sibling::div//div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),"The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        sleepInSeconds(3);

        switchWindowByTitle("Products Comparison List - Magento Commerce");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(),"COMPARE PRODUCTS");

        driver.close();
        switchWindowByTitle("Mobile");
        driver.findElement(By.cssSelector("input#search")).sendKeys("Samsung Galaxy");
        sleepInSeconds(3);

    }

    @Test
    public void TC_15_Selenium_Ver4() {
        driver.get("http://live.techpanda.org/");
        System.out.println("Driver ID " + driver.toString());


        // New 1 window in current browser
        driver.switchTo().newWindow(WindowType.TAB);
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
    public void switchWindow (String expectedID) {
        // Get Set of string of all window IDS (Set: unique; List : not unique)
        Set<String> allIDs = driver.getWindowHandles();
        // If 1 ID is different from current window ID, then switch into it
        for (String ID : allIDs){
            if(!ID.equals(expectedID)) {
                driver.switchTo().window(ID);
                break;
            }
        }
    }
    public void switchWindowByTitle (String expectedTitle) {
        // Get Set of string of all window IDS (Set: unique; List : not unique)
        Set<String> allIDs = driver.getWindowHandles();
        // If 1 ID is different from current window ID, then switch into it
        for (String ID : allIDs){
            driver.switchTo().window(ID);
            String windowTitle = driver.getTitle();
            if(windowTitle.equals(expectedTitle)) {
                driver.switchTo().window(ID);
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent (String parentID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String ID : allIDs){
            if (!ID.equals(parentID)) {
                driver.switchTo().window(ID);
                System.out.println(ID);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
        System.out.println(parentID);
    }
}