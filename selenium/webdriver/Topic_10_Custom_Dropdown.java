package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Topic_10_Custom_Dropdown {
    WebDriver driver;
    // Explicit Wait - Wait tường minh: chờ 1 trạng thái cụ thể của element
    // Visible/ Invisible/ Presence/ Number/ Clickable/ ..
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass() {
        // Init driver
        driver = new ChromeDriver();
        // Init Wait
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        // Implicit Wait - Wait ngầm định: ko rõ ràng việc chờ cho trạng thái cụ thể nào. Dùng cho findElement
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
    }

    @Test
    public void TC_00() {
        // 1. Click 1 dropdown field to expand all items
        driver.findElement(By.id("number-button")).click();
        sleepInSeconds(5);
        // 2.1 Expand and display all items
        // 2.2 Expand and only display some items. Remaining is loading. Wait until all remaining items display.
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
        // 3.1 If element displays > onclick to select
        // 4. Check all option text. If match the option needed to be select > onclick
        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
        for (WebElement item : allItems) {
            String textOfItem = item.getText();
            if (textOfItem.equals("8")){
                item.click();
                break;
            }
        }


    }

    @Test
    public void TC_01_JQuery() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInDropdown("span#speed-button", "ul#speed-menu div","Faster");
        sleepInSeconds(3);

        selectItemInDropdown("span#number-button", "ul#number-menu div","8");
        sleepInSeconds(3);

        selectItemInDropdown("span#files-button", "ul#files-menu div","ui.jQuery.js");
        sleepInSeconds(3);

        selectItemInDropdown("span#salutation-button", "ul#salutation-menu div","Mr.");
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"8");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(),"ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Mr.");

    }

    @Test
    public void TC_02_React() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInDropdown("i.dropdown.icon", "div.item>span.text","Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Christian");
        sleepInSeconds(3);

    }

    @Test
    public void TC_03_VueJs() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
        sleepInSeconds(3);

    }

    @Test
    public void TC_04_Editable() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInEditableDropdown("input.search", "div.item span","Belarus");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Belarus");
        sleepInSeconds(3);

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

    public void selectItemInDropdown(String parentCss, String childItemCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).click();
        sleepInSeconds(5);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));
        for (WebElement item : allItems) {
            String textOfItem = item.getText();
            if (textOfItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }

    public void selectItemInEditableDropdown(String parentCss, String childItemCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        sleepInSeconds(5);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));
        for (WebElement item : allItems) {
            String textOfItem = item.getText();
            if (textOfItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }

}