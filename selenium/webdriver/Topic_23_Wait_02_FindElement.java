package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_23_Wait_02_FindElement {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        // Implicit wait - 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Find_Element() {
        // Case 1 - 1 Element is found within timeout
        // Không cần chờ hết timeout.
        // Tìm thấy sẽ trả lại 1 WebElement.
        // Sang step tiếp theo
                System.out.println("Start step : " + getDateTimeNow());
                driver.findElement(By.cssSelector("input#email"));
                System.out.println("End step : " + getDateTimeNow());


        // Case 2 - Multiple elements are found within timeout
        // Không cần chờ hết timeout.
        // Tìm thấy sẽ trả lại 1 WebElement đầu tiên.
        // Sang step tiếp theo
                System.out.println("Start step : " + getDateTimeNow());
                driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("test");
                System.out.println("End step : " + getDateTimeNow());


        // Case 3 - No element found
        // Chờ hết timeout 10s
        // Trong tgian 10s, cứ mỗi nửa s sẽ quét tìm lại 1 lần.
        // Nếu tìm lại và thấy thì trả 1 WebElement và sang step tiếp theo
        // Nếu tìm lại và ko thấy thì đánh fail testcase và throw NoSuchElementException
                System.out.println("Start step : " + getDateTimeNow());
                driver.findElement(By.cssSelector("input[name='reg_email__']"));
                System.out.println("End step : " + getDateTimeNow());
    }

    @Test
    public void TC_02_Find_Elements() {
        List<WebElement> elementList;
        // Case 1 - 1 Element is found within timeout
        // Không chờ hết timeout 10s
        // Trả về 1 List Element chứa đúng 1 element
        System.out.println("Start step : " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#email"));
        System.out.println("List element contains : " + elementList.size());
        System.out.println("End step : " + getDateTimeNow());


        // Case 2 - Multiple elements are found within timeout
        // Không chờ hết timeout 10s
        // Trả về 1 List Element chứa nhiều element
        System.out.println("Start step : " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        System.out.println("List element contains : " + elementList.size());
        System.out.println("End step : " + getDateTimeNow());


        // Case 3 - No element found
        // Chờ hết timeout 10s
        // Tìm lại 1 lần mỗi 10s
        // Nếu tìm lại và thấy thì trả lại list chứa các element tìm thấy
        // Nếu hết tgian tìm lại và ko thấy thì trả lại 1 list rỗng (empty) và không đánh fail testcase
        // Qua step tiếp theo
        System.out.println("Start step : " + getDateTimeNow());
        driver.findElement(By.cssSelector("input[name='reg_email__']"));
        System.out.println("End step : " + getDateTimeNow());

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public static String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }

}