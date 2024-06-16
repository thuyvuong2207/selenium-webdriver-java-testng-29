package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

@Test
public class Topic_07_SwitchCase {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    Scanner scanner = new Scanner(System.in);

    public void TC_01(String BrowserName) {
        driver = getBrowserDriver(BrowserName);
        System.out.println(BrowserName);
        driver.quit();
    }

    public void TC_02_SwitchCase() {
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Month with 31 days");
                break;
            case 2:
                System.out.println("Month with 28 days");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Month with 30 days");
                break;
            default:
                System.out.println("Wrong month input format");
        }
    }

    public WebDriver getBrowserDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                System.out.println(browserName);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                System.out.println(browserName);
                break;
            case "edge":
                driver = new EdgeDriver();
                System.out.println(browserName);
                break;
            case "safari":
                driver = new SafariDriver();
                System.out.println(browserName);
                break;
            default:
                new RuntimeException("Incorrect Browser Name");
                break;
        }
        return driver;
    }
}