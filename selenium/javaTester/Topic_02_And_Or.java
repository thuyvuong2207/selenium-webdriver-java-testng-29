package javaTester;

//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;

public class Topic_02_And_Or {

    public static void main(String[] args) {
        boolean member01;
        boolean member02;

        //AND
        // Case1
        member01 = true;
        member02 = true;
        System.out.println("Result =" + (member01 && member02));

        // Case2
        member01 = false;
        member02 = false;
        System.out.println("Result =" + (member01 && member02));

        // Case3
        member01 = true;
        member02 = false;
        System.out.println("Result =" + (member01 && member02));

        // Case4
        member01 = false;
        member02 = true;
        System.out.println("Result =" + (member01 && member02));

        //OR
        // Case1
        member01 = true;
        member02 = true;
        System.out.println("Result =" + (member01 || member02));

        // Case2
        member01 = false;
        member02 = false;
        System.out.println("Result =" + (member01 || member02));

        // Case3
        member01 = true;
        member02 = false;
        System.out.println("Result =" + (member01 || member02));

        // Case4
        member01 = false;
        member02 = true;
        System.out.println("Result =" + (member01 || member02));

    }
}
