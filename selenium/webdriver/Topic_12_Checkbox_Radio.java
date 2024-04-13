 package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

 public class Topic_12_Checkbox_Radio {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_02_Default_Checkbox_Radio() {
        // Checkbox
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        driver.manage().window().maximize();
        sleepInSeconds(10);
        By InputCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        checkElement(InputCheckbox);
        Assert.assertTrue(driver.findElement(InputCheckbox).isSelected());

        uncheckElement(InputCheckbox);
        Assert.assertFalse(driver.findElement(InputCheckbox).isSelected());

        // Radio
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        sleepInSeconds(3);
        By InputRadio = By.cssSelector("input#engine3");

        checkElement(InputRadio);
        Assert.assertTrue(driver.findElement(InputRadio).isSelected());
    }


    @Test
    public void TC_03_Default_Checkbox_Radio() {
        // Checkbox
        driver.get("https://material.angular.io/components/radio/examples");
        driver.manage().window().maximize();
        sleepInSeconds(10);
        By InputCheckbox = By.cssSelector("input[value='Summer']");

        checkElement(InputCheckbox);
        Assert.assertTrue(driver.findElement(InputCheckbox).isSelected());

        // Checkbox 2
        driver.get("https://material.angular.io/components/checkbox/examples");
        sleepInSeconds(3);
        By InputChecked = By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
        By InputIndeterminate = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");


        checkElement(InputChecked);
        checkElement(InputIndeterminate);
        Assert.assertTrue(driver.findElement(InputChecked).isSelected());
        Assert.assertTrue(driver.findElement(InputIndeterminate).isSelected());

    }

    @Test
    public void TC_04_Select_All_Checkboxes() {
        // Checked all checkboxes
        driver.get("https://automationfc.github.io/multiple-fields/");
        driver.manage().window().maximize();
        sleepInSeconds(10);
        By AllCheckboxes = By.cssSelector("div.form-single-column input[type='checkbox']");

        List <WebElement> allCheckboxes = driver.findElements(AllCheckboxes);
        for(WebElement oneCheckbox : allCheckboxes) {
            if (!oneCheckbox.isSelected()){
                oneCheckbox.click();
                sleepInSeconds(1);
            }
        }

        // Verify all checkboxes are checked
        for(WebElement oneCheckbox : allCheckboxes) {
            Assert.assertTrue(oneCheckbox.isSelected());
        }

        // Refresh and select 1 checkbox only
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        By checkboxHeartAttack = By.xpath("//label[text()=' Heart Attack ']/preceding-sibling::input");
        if (!driver.findElement(checkboxHeartAttack).isSelected()) {
            driver.findElement(checkboxHeartAttack).click();
            sleepInSeconds(2);
        }
        Assert.assertTrue(driver.findElement(checkboxHeartAttack).isSelected());

    }

     @Test
     public void TC_06_Custom_Checkbox_Or_Radio() {
         driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
         sleepInSeconds(5);
         By CanThoButtonFalse = By.cssSelector("div[data-value='Cần Thơ'][aria-checked='false']");
         By CanThoButtonTrue = By.cssSelector("div[data-value='Cần Thơ'][aria-checked='true']");

         Assert.assertTrue(driver.findElement(CanThoButtonFalse).isDisplayed());

         if (driver.findElement(CanThoButtonFalse).isDisplayed()) {
             checkElement(CanThoButtonFalse);
             sleepInSeconds(2);
             Assert.assertTrue(driver.findElement(CanThoButtonTrue).isDisplayed());
         } else {
             Assert.assertTrue(driver.findElement(CanThoButtonTrue).isDisplayed());
         }
     }


    public void checkElement (By ElementXpathOrCss) {
        // If Element is unselected, then onclick checkbox
    if (!driver.findElement(ElementXpathOrCss).isSelected()) {
        driver.findElement(ElementXpathOrCss).click();
        sleepInSeconds(2);
    }
}
public void uncheckElement (By ElementXpathOrCss) {
        // If Element is selected, then onclick checkbox
        if (driver.findElement(ElementXpathOrCss).isSelected()) {
            driver.findElement(ElementXpathOrCss).click();
            sleepInSeconds(2);
        }
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