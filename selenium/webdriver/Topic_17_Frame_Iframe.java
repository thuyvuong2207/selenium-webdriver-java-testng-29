package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Frame_Iframe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    @Test
    public void TC_11_Iframe_Form_site() {
        // Open page domain formsite
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        sleepInSeconds(5);
        driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();
        sleepInSeconds(3);
        WebElement formIframe = driver.findElement(By.cssSelector("div#formTemplateContainer iframe"));
        Assert.assertTrue(formIframe.isDisplayed());

        // Switch from formsite domain to iframe
//        driver.switchTo().frame("frame-one85593366"); // ID might change when reload
//        driver.switchTo().frame(0); // index might change when add new iframe
        driver.switchTo().frame(formIframe); // rarely change
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Junior");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("North Dorm");
        driver.findElement(By.cssSelector("label[for='RESULT_RadioButton-4_1']")).click();
        driver.findElement(By.cssSelector("input[name='Submit']")).click();

        // Switch back to default domain
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("nav.header--desktop-floater a.menu-item-login")).click();
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("button#login")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error"))
                .getText(),"Username and password are both required.");

/*
        // Switch from B to C
        driver.switchTo().frame("");
        // Return to B (parentFrame0
        driver.switchTo().parentFrame();
        // Return to A (default domain/content)
        driver.switchTo().defaultContent();*/
    }

    @Test
    public void TC_12_Frame_HDFC_Bank() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        sleepInSeconds(10);

        WebElement loginPage = driver.findElement(By.cssSelector("frame[name='login_page']"));
        driver.switchTo().frame(loginPage);
        sleepInSeconds(5);

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("automationtest");
        driver.findElement(By.cssSelector("a.btn-primary.login-btn")).click();
        sleepInSeconds(5);
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Password/IPIN']/following-sibling::md-input-container/input"))
                .isDisplayed());

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