package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

 public class Topic_13_Alert {
     WebDriver driver;
     @BeforeClass
     public void beforeClass() {
         // Init driver
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     }

     @Test
     public void TC_07_Accept_Alert () {
         driver.get("https://automationfc.github.io/basic-form/index.html");
         sleepInSeconds(3);
         driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
         sleepInSeconds(3);

         Alert acceptAlert = driver.switchTo().alert();
         String textOnAcceptAlert = acceptAlert.getText();
         Assert.assertEquals(textOnAcceptAlert, "I am a JS Alert");
         acceptAlert.accept();
     }

     @Test
     public void TC_08_Confirm_Alert () {
         driver.get("https://automationfc.github.io/basic-form/index.html");
         sleepInSeconds(3);
         driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
         sleepInSeconds(3);

         Alert confirmAlert = driver.switchTo().alert();
         String textOnConfirmAlert = confirmAlert.getText();
         Assert.assertEquals(textOnConfirmAlert, "I am a JS Confirm");
         confirmAlert.dismiss();

         Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");
     }

     @Test
     public void TC_09_Prompt_Alert () {
         driver.get("https://automationfc.github.io/basic-form/index.html");
         sleepInSeconds(3);
         driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
         sleepInSeconds(3);

         Alert promptAlert = driver.switchTo().alert();
         String input = "Automation Testing";
         promptAlert.sendKeys(input );
         sleepInSeconds(3);
         promptAlert.accept();

         Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: " + input);
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