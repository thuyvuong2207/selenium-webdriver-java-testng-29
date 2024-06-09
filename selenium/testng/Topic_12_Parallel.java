package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_12_Parallel {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test()
    public void TC_01() {
        driver.get("http://live.techpanda.org/index.php");
        System.out.println("TC_01");
    }
    @Test()
    public void TC_02() {
        driver.get("http://live.techpanda.org/index.php");
        System.out.println("TC_02");
    }
    @Test()
    public void TC_03() {
        driver.get("http://live.techpanda.org/index.php");
        System.out.println("TC_03");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
