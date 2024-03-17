package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_04_XPath_Css {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_Data() {
        // Action
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        // Action
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Thuy");
        driver.findElement(By.id("txtEmail")).sendKeys("1212@23@44");
        driver.findElement(By.id("txtCEmail")).sendKeys("1212@23@44");
        driver.findElement(By.id("txtPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtCPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtPhone")).sendKeys("0936111111");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        // Action
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Thuy");
        driver.findElement(By.id("txtEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("1212@23@44");
        driver.findElement(By.id("txtPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtCPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtPhone")).sendKeys("0936111111");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void Register_04_Invalid_Password() {
        // Action
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Thuy");
        driver.findElement(By.id("txtEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("thuy");
        driver.findElement(By.id("txtCPassword")).sendKeys("thuy");
        driver.findElement(By.id("txtPhone")).sendKeys("0936111111");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void Register_05_Invalid_Confirmation_Password() {
        // Action
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Thuy");
        driver.findElement(By.id("txtEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtCPassword")).sendKeys("thuy123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0936111111");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void Register_06_Invalid_Phone_Number(){
        // Phone nụmber < 10 chars
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Thuy");
        driver.findElement(By.id("txtEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtCPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtPhone")).sendKeys("0936111");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify 1
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // Phone nụmber > 11 chars
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();

        driver.findElement(By.id("txtFirstname")).sendKeys("Thuy");
        driver.findElement(By.id("txtEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtCPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtPhone")).sendKeys("093611111111");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify 2
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // Phone nụmber stats with Phone center number
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();

        driver.findElement(By.id("txtFirstname")).sendKeys("Thuy");
        driver.findElement(By.id("txtEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("thuyvm@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtCPassword")).sendKeys("thuyvm@2132");
        driver.findElement(By.id("txtPhone")).sendKeys("12345678901");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify 3
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}