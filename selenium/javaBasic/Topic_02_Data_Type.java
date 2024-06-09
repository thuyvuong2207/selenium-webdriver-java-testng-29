package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Topic_02_Data_Type {
    // Global variable
    static int number;

    public static void main(String[] args) {
        // Local variable
        int studentNumber = 0;
        System.out.println(number);
        System.out.println(studentNumber);
    }

    // Primitive type
    byte bNumber = 6;
    short sNumber = 126;
    int iNumber = 6500;
    long lNumber = 650000;
    float fNumber = 15.98f;
    double dNumber = 15.98d;
    char cChar = 'c';
    boolean bStatus = false;
    // Reference type
    // String
    String address = "Hanoi";
    // Array
    String[] studentAddress = {address, "Hochiminh", "Danang"};
    Integer[] studentNumber = {15, 20, 25};
    // Class
    Topic_02_Data_Type topic;
    // Interface
    WebDriver driver = new ChromeDriver();
    // Object
    Object aObject;
    // Collection
    // List/ Set/ Queue/ Map
    List<WebElement> newList = driver.findElements(By.xpath(""));
    Set<String> allWindow = driver.getWindowHandles();

    public void clickToElement() {
        address.trim();
        studentAddress.clone();
        driver.getCurrentUrl();
        aObject.toString();
        allWindow.clear();
    }
}