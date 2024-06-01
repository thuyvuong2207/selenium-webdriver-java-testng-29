package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Loop_Invocation {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

        @Test (invocationCount = 5)
        public void Login_05_Succeed() {
            // Register new account
            driver.get("http://live.techpanda.org/index.php");
            driver.findElement(By.xpath("//div[@class='footer']//li/a[@title='My Account']")).click();
            driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

            String firstname = "Automation", lastname = "FC", email = getEmailAddress(), password = "1234567";
            driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstname);
            driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastname);
            driver.findElement(By.cssSelector("input#email_address")).sendKeys(email);
            driver.findElement(By.cssSelector("input#password")).sendKeys(password);
            driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
            driver.findElement(By.cssSelector("button[title='Register']")).click();

            // Verify successful register
            Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
            Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + firstname + " " + lastname + "!");

            String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
            Assert.assertTrue(contactInfo.contains(firstname + " " + lastname));
            Assert.assertTrue(contactInfo.contains(email));
            System.out.println(email);

            // Logout
            driver.findElement(By.cssSelector("a.skip-account")).click();
            driver.findElement(By.cssSelector("a[title='Log Out']")).click();
    }

    public String getEmailAddress(){
        return "automation" + new Random().nextInt(9999) + "@gmail.com";
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
