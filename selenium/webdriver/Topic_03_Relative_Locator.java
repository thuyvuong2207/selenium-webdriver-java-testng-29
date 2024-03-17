package webdriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class  Topic_03_Relative_Locator {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Relative() {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");

        // Login (Above on UI)
        // Loginbutton option 1
        By loginButtonBy = By.cssSelector("button.login-button");
        // Loginbutton option 2
        WebElement loginButtonElement = driver.findElement(By.cssSelector("button.login-button"));

        RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy);
        RelativeLocator.with(By.tagName("label"))
                .above(loginButtonElement);

        // Remember me checkbox ( on UI)
        By rememberMeCheckbox = By.id("RememberMe");
        WebElement rememberMeTextElement = driver
                .findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)
                .toRightOf(rememberMeCheckbox));
        System.out.println(rememberMeTextElement.getText());
    }

// find relative locator: above login button and right of rememberMeCheckbox
//        RelativeLocator.with(By.tagName("label"))
//                .above(loginButtonBy)
//                .toRightOf(rememberMeCheckbox);
//    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}