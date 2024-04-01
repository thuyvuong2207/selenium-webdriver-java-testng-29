package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_09_Default_Dropdown {
    WebDriver driver;
    String firstName = "Thuy", lastName = "Vuong", emailAddress = getEmailAddress(), companyName = "", password = "";
    String day = "15", month = "November", year = "1950";
    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByVisibleText("15");
//        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
//        day.selectByVisibleText("November");
//        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
//        day.selectByVisibleText("1950");

        //Verify single/ multiple dropdown
        Assert.assertFalse(day.isMultiple());
//        Assert.assertFalse(month.isMultiple());
//        Assert.assertFalse(year.isMultiple());

        //Verify option count
        /*List<WebElement> dayOptions = day.getOptions();
        Assert.assertEquals(dayOptions.size(),32);*/
        Assert.assertEquals(day.getOptions().size(),32);

        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password );
        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")),"Your registration completed");
    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demo.nopcommerce.com/");

        // Login
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button#login-button")).click();
        sleepInSeconds(2);

        // Verify
        driver.findElement(By.className("ico-account")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastName);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);
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

    public String getEmailAddress(){
        /*Random rand = new Random();
        String emailAddress = "automation" + rand.nextInt(9999) + "@gmail.com";
        return emailAddress;*/
        return "thuy" + new Random().nextInt(9999) + "@gmail.com";
    }
}