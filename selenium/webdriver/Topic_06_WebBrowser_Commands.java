package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
    // Cac cau lenh de thao tac voi Browser : driver.
    WebDriver driver;
    // Cac cau lenh de thao tac voi Element : element.
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new FirefoxDriver();
        driver = new SafariDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_() {
        driver.get("https://www.facebook.com/");

        driver.close(); // close 1 tab
        driver.quit(); // quit browser

        driver.findElement(By.id("Email"));
        // if fail, not found - throwException: NoSuchElementException
        // if pass, return WebElement
        WebElement emailAddress = driver.findElement(By.id("Email"));

        // init and declare List for WebElement type
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(1).click();

        // Get data
        driver.get("https://www.facebook.com/");
        driver.getCurrentUrl();
        driver.getPageSource();
        driver.getTitle();

        // Handle window/tab
        driver.getWindowHandle();
        driver.getWindowHandles();

        // Cookies-framework
        driver.manage().getCookies();

        // Get log from devtool tab
        driver.manage().logs().get(LogType.DRIVER);

        // Timeout (apply for findElement and findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30 ));

        // Payload timeout (wait for 1 page to finish loading)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Script timeout (set before using JavascriptExecutor - inject code js into Browser/ Element)
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // GUI - responsive
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().getSize();
        driver.manage().window().setPosition(new Point(3,3));
        driver.manage().window().getPosition();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}