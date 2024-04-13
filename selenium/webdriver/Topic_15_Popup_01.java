package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_Popup_01 {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Fixed_Pop_In_DOM_01 () {
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.cssSelector("button.login_")).click();
        sleepInSeconds(3);

        // Check Login popup display
        By LoginPopup = By.cssSelector("div[id='modal-login-v1'][style] div.modal-content");
        Assert.assertTrue(driver.findElement(LoginPopup).isDisplayed());

        // Check Alert message for non-existent account
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.modal-content input#account-input"))
                .sendKeys("automationfc");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.modal-content input#password-input"))
                .sendKeys("automationfc");
        driver.findElement(By.cssSelector("div#modal-login-v1[style] button.btn-login-v1")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.error-login-panel")).getText(),"Tài khoản không tồn tại!");
    }

    @Test
    public void TC_03_Fixed_Pop_Not_In_DOM_03 () {
        driver.get("https://tiki.vn/");
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        By PopupModal = By.cssSelector("div.ReactModal__Content");
        Assert.assertTrue(driver.findElement(PopupModal).isDisplayed());

        driver.findElement(By.cssSelector("p.login-with-email")).click();
        sleepInSeconds(3);
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']/parent::div/following-sibling::span[1]"))
                .getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']/parent::div/following-sibling::span[2]"))
                .getText(),"Mật khẩu không được để trống");

        // Close popup verify - HTML not in DOM
        driver.findElement(By.cssSelector("button.btn-close")).click();
        sleepInSeconds(2);
        // findElements(By) and assert zero length response
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(),0);

    }

    @Test
    public void TC_04_Fixed_Pop_Not_In_DOM_04 () {
        driver.get("https://www.facebook.com/");
        sleepInSeconds(2);
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        sleepInSeconds(2);

        By SignUpPopup = By.xpath("//div[text()='Sign Up']/parent::div/parent::div");
        Assert.assertTrue(driver.findElement(SignUpPopup).isDisplayed());

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSeconds(2);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).size(),0);

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