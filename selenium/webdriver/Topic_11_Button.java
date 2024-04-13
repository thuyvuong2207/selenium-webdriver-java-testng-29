package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_11_Button {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
    }

    @Test
    public void TC_01_Button () {
        driver.get("https://www.fahasa.com/customer/account/create");
        sleepInSeconds(3);
        driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
        sleepInSeconds(2);
        WebElement LoginButton = driver.findElement(By.cssSelector("div.popup-login-content button[title='Đăng nhập']"));

        // Verify button Login disabled state
        if (LoginButton.isEnabled()){
            System.out.println("Button Login enabled");
        } else {
            System.out.println("Button Login disabled");
        }
//
//        // Get button Login background color in RGB
//        String LoginButtonColorRGB = LoginButton.getCssValue("background-color");
//        System.out.println("Background color RGB" + LoginButtonColorRGB );
//
//        // Convert String RGB to Color
//        Color LoginButtonColor = Color.fromString(LoginButtonColorRGB);
//
//        // Convert Color to Hexa
//        String loginButtonColorAsHex = LoginButtonColor.asHex().toLowerCase();
//        System.out.println(loginButtonColorAsHex);

        // Verify
        Assert.assertEquals((Color.fromString(LoginButton.getCssValue("background-color"))).asHex().toLowerCase(), "#000000");

        // Input value in email/pw and verify button enabled, color red
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("0936017840");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("abc123");
        if (LoginButton.isEnabled()){
            System.out.println("Button Login enabled");
        } else {
            System.out.println("Button Login disabled");
        }

        String colorButtonEnabledRGB = LoginButton.getCssValue("background-color");
        System.out.println("Background enabled" + colorButtonEnabledRGB);
        Color colorButtonEnabled = Color.fromString(colorButtonEnabledRGB);
        String colorButtonEnabledAsHex = colorButtonEnabled.asHex().toLowerCase();
        System.out.println(colorButtonEnabledAsHex);

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