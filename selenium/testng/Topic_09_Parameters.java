package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic_09_Parameters {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @Parameters({"browser", "version"})
    @BeforeClass
    public void beforeClass(String browser, String version) {
        driver = getBrowserDriver(browser);
        System.out.println("Browser" + browser + "with version" + version);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

@Parameters("environment")
    @Test()
    public void TC_01_LoginToSystem(@Optional("live") String environment) {
        // Optional - if environment is not specified on testng.xml then param calls @optional env.
        driver.get(getEnvironmentName(environment));

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("111111");
        driver.findElement(By.xpath("//*[@id='send2']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01"));


        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    private WebDriver getBrowserDriver(String browser) {
        WebDriver driver;
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("safari")) {
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        return driver;
    }

    private String getEnvironmentName(String environment) {
        String urlValue;
        if (environment.equals("dev")) {
           urlValue = "http://live.techpanda.org/index.php/customer/account/login/";
        } else if (environment.equals("stag")) {
            urlValue = "http://live.techpanda.org/index.php/customer/account/login/";
        } else if (environment.equals("prod")) {
            urlValue = "http://live.techpanda.org/index.php/customer/account/login/";
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        return urlValue;
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
