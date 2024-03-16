package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        }

        driver = new ChromeDriver();
        driver.manage().timeouts(). implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }
// TestNG: order TC alphabetically (A-Z 0-9)
// HTML element : <tagName attribute_name1='attribute_value' attribute_name2='attribute_value'>
/*<input class="email" autofocus="" type="email" data-val="true" data-val-email="Wrong email" data-val-required="Please enter your email" id="Email" name="Email">
*/

    // Selenium version 1.x 2.x 3.x 4.x
    // 8 locators
    // Selenium locators = HTML attributes
    // id - class - name = trung voi 3 HTML attributes
    // LinkText/ Partial LinkText: HTML Link (thẻ <a>)
    // tagName: HTML
    // Css/


    // Selenium version 4.x - GUI (Graphic User Interface)
    // Relative locator
    // above/ below/ near/ leftOf/ rightOf

    // UI Testing
    // FUI - Functional UI
    // GUI - Graphic UI (font, size, color, position, location, resolution, responsive etc.)
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("Thuy");
//        System.out.println(driver.findElement(By.id("Email")));
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));

    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_tagName() {
        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText() {
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        // Search for any char at beginning/mid/end of string
        driver.findElement(By.partialLinkText("Shipping &"));
        driver.findElement(By.partialLinkText("returns"));
        driver.findElement(By.partialLinkText("g & retu"));

    }

    @Test
    public void TC_07_Css() {
        // CSS with ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // CSS with Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // CSS with Name (full)
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // CSS with tagName
        driver.findElement(By.cssSelector("input"));

        // CSS with link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        // CSS with partial link
        driver.findElement(By.cssSelector("a[href*='addresses']")); // * anywhere in string
        //driver.findElement(By.cssSelector("a[href^='addresses']")); // ^ beginning
        //driver.findElement(By.cssSelector("a[href$='addresses']")); // $ end of string

    }

    @Test
    public void TC_08_Xpath() {

        // CSS with ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // CSS with Class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        // CSS with Name (full)
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // CSS with tagName
        driver.findElement(By.xpath("//input"));

        // CSS with link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));  // search by link href
        driver.findElement(By.xpath("//a[text()='Addresses']"));  // search by linkText


        // CSS with partial link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}