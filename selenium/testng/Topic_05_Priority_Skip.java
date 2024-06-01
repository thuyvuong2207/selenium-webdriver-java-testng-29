package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class Topic_05_Priority_Skip {

    @Test(priority = 3, enabled = false)
    public void TC_01_search_with_date() {
        System.out.println("TC_01");

    }

    @Test(priority =  2)
    public void TC_02_search_with_billing() {
        System.out.println("TC_02");

    }

    @Test (priority = 1)
    public void TC_03_search_with_payment() {
        System.out.println("TC_03");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
}
