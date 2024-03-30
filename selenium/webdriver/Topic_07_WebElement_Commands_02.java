package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_isDisplayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);

        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
            System.out.println("Email textbox is displayed");
        } else {
            System.out.println("Email texbox is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Under 18 radio button is displayed");
        } else {
            System.out.println("Under 18 radio button is not displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
            System.out.println("Education is displayed");
        } else {
            System.out.println("Education is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name: User 5 is displayed");
        } else {
            System.out.println("Name: User 5 is not displayed");
        }
    }

    @Test
    public void TC_02_isEnabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);

        // Enabled verify
        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            System.out.println("Email textbox is enabled");
        } else {
            System.out.println("Email texbox is disabled");
        }
        if (driver.findElement(By.cssSelector("input#under_18")).isEnabled()) {
            System.out.println("Under 18 radio button is enabled");
        } else {
            System.out.println("Under 18 radio button is disabled");
        }
        if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled()) {
            System.out.println("Education is enabled");
        } else {
            System.out.println("Education is disabled");
        }
        if (driver.findElement(By.cssSelector("select#job1")).isEnabled()) {
            System.out.println("Job Role 01 is enabled");
        } else {
            System.out.println("Job Role 01 is disabled");
        }
        if (driver.findElement(By.cssSelector("input#slider-1")).isEnabled()) {
            System.out.println("Slider 01 is enabled");
        } else {
            System.out.println("Slider 01 is disabled");
        }

        // Disabled verify
        if (driver.findElement(By.cssSelector(" input#disable_password")).isEnabled()) {
            System.out.println("Password is enabled");
        } else {
            System.out.println("Password is disabled");
        }
        if (driver.findElement(By.cssSelector("radio-disabled")).isEnabled()) {
            System.out.println("Radio disabled is enabled");
        } else {
            System.out.println("Radio disabled is disabled");
        }
        if (driver.findElement(By.cssSelector("textarea#bio")).isEnabled()) {
            System.out.println("Bio is enabled");
        } else {
            System.out.println("Bio is disabled");
        }
        if (driver.findElement(By.cssSelector("select#job3")).isEnabled()) {
            System.out.println("Job Role 03 is enabled");
        } else {
            System.out.println("Job Role 03 is disabled");
        }
        if (driver.findElement(By.cssSelector("input#check-disbaled")).isEnabled()) {
            System.out.println("Interest checkbox is enabled");
        } else {
            System.out.println("Interest checkbox is disabled");
        }
        if (driver.findElement(By.cssSelector("input#slider-2")).isEnabled()) {
            System.out.println("Slider 02 is enabled");
        } else {
            System.out.println("Slider 02 is disabled");
        }
    }

    @Test
    public void TC_03_isSelected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);

        // Action
        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();
        sleepInSeconds(3);

        // Selected verify
        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());

        // Action 2
        driver.findElement(By.cssSelector("input#java")).click();
        sleepInSeconds(3);

        // Unselected verify
        Assert.assertFalse(driver.findElement(By.cssSelector("input#java")).isSelected());
    }

    @Test
    public void TC_04_RegisterAtMailchimp() {
        driver.get("https://login.mailchimp.com/signup/");
        sleepInSeconds(3);

        // Action
        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("vuongminhthuy97@gmail.com");
        sleepInSeconds(3);

        // Verify number only input
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("9");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check not-completed']")).isDisplayed());

        // Verify lowercase text only input
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("thuy");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check not-completed']")).isDisplayed());

        // Verify uppercase text only input
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("THUY");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check not-completed']")).isDisplayed());

        // Verify special char only input
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@#$");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        // Verify >8 chars input
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Inputcharacters");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        // Valid
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Thuyvm@12345");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
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