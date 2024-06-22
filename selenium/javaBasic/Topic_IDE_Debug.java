package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Topic_IDE_Debug {
    WebDriver driver;
    @Test
    public void TC_01(){
        driver = new ChromeDriver();
        driver.get("https://facebook.com");
        String headerText = driver.findElement(By.xpath("//img/[@alt='Facebook']/parent::div/following-sibling::h2")).getText();
        Assert.assertEquals(headerText, "Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn.");

        boolean loginStatus = driver.findElement(By.name("login")).isDisplayed();
        Assert.assertTrue(loginStatus);
    }
}

