package webdriver;

import graphql.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class Topic_26_Wait_05_Explicit_01_Knowledge {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @Test
    public void TC_01_Explicit_Wait_Basic() {
        // Chờ cho 1 Alert presence trong DOM trước khi thao tác lên
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        // Chờ cho 1 element không còn ở trong DOM
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // Chờ cho 1 element có trong DOM (không quan tâm có trên UI không)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // Chờ cho 1 list element có trong DOM
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        // Chờ cho 1-n element được hiển thị trên UI
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")), driver.findElement(By.cssSelector(""))));

        // Chờ cho element biến mất (ko còn hiển thị trên UI)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // Chờ cho element clickable (link/ button/ checkbox/ radio)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // Chờ đến khi trang có title mong muốn load xong
        explicitWait.until(ExpectedConditions.titleIs("Create New Account"));
        driver.getTitle();

        // Chờ đến khi thoả mãn nhiều điều kiện - and/ or
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),
                ExpectedConditions.titleContains("")
        ));

        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),
                ExpectedConditions.titleContains("")
        ));

        // Chờ đến khi attribute của element hiển thị/ có value như mong muốn
        // Tương đối - contains
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector(""), "placeholder", "Search entire"));
        // Tuyệt đối - tobe
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""), "placeholder", "Search entire"));
        // Not null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")), "placeholder"));

        // DOM attribute and property tobe
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),"placeholder", "Search entire"));
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")),"placeholder", "Search entire"));

        // Chờ cho 1 element được select thành công
        // Checkbox/ Radio/ Dropdown item (default)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // Chờ cho 1 element đã được selected
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), true));
        // Chờ cho 1 element chưa được selected
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), false));

        // Chờ frame available và có thể switch vào
        // By name/ id
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt( "name/id of frame"));
        // By index of frame
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt( 1));
        // By or element of frame
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt( By.cssSelector( "")));

        // Chờ cho 1 đoạn code JS trả về giá trị
        explicitWait.until(ExpectedConditions.jsReturnsValue(""));
        // Chờ cho 1 đoạn code JS chạy thành công (ko error ko throw exception)
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions(""));
        // Ko throw exception: true
        Assert.assertTrue(explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("")));
        // Có ngoại lệ : false
        Assert.assertTrue(explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("")));

        // Chờ cho số lượng element bằng 1 con số nhất định
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""), 5));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""), 6));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""), 6));

        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(6));

        // Chờ cho text thoả mãn điều kiện
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""), ""));

        Pattern pattern = Pattern.compile("", Pattern.CASE_INSENSITIVE);
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector(""),  pattern));
        // Bắt buộc text present trong DOM
        explicitWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("")), ""));

        // Chờ đến khi URL hiện tại thoả mãn điều kiện
        explicitWait.until(ExpectedConditions.urlToBe("https://facebook.com"));
        explicitWait.until(ExpectedConditions.urlContains("facebook.c"));
        explicitWait.until(ExpectedConditions.urlMatches("[^abc]"));

        // Chờ cho 1 điều kiện mà element bị update lại trạng thái / reload HTML/ re-render
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeSelected(By.cssSelector(""))));

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}