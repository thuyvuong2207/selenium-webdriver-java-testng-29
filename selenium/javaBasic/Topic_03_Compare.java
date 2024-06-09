package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Topic_03_Compare {
    int number = 8;
    public static void main(String[] args) {
        // 1 vung nho cho bien x - stack
        int x = 5;
        // 1 vung nho cho bien y - heap
        int y = x;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        y = 10;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        Topic_03_Compare firstVariable  = new Topic_03_Compare();
        Topic_03_Compare secondVariable = new Topic_03_Compare();

        System.out.println("firstVariable = " + firstVariable.number);
        System.out.println("secondVariable = " + secondVariable.number);

        secondVariable.number = 15;
        System.out.println("firstVariable = " + firstVariable.number);
        System.out.println("secondVariable = " + secondVariable.number);

    }

}