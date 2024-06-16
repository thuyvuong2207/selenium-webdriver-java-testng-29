package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_06_Condition_Statement {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01(String BrowserName){
        driver = getBrowserDriver(BrowserName);
        System.out.println(BrowserName);
        driver.quit();
    }

    @Test
    public void TC_02_If_ElseIf() {
        int month = scanner.nextInt();
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
            System.out.println("Month with 31 days");
        } else if ( month == 2) {
            System.out.println("Month with 28 days");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println("Month with 30 days");
        } else {
            System.out.println("Wrong month input format");
        }
    }


    public WebDriver getBrowserDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                new RuntimeException("Incorrect Browser Name");
                break;
        }
    return driver;
    }
}