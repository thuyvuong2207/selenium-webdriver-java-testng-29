package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_04_Always_Run {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        Assert.assertTrue(false);
    }
    // If failed in BeforeClass > other test and Afterclass will not run

    @Test
    public void TC_01_() {
        System.out.println("TC_01");

    }

    @Test
    public void TC_02_() {
        System.out.println("TC_02");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
}
