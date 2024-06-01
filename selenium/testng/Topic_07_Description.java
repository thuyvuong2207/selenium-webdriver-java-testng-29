package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class Topic_07_Description {

    @Test(priority = 3, enabled = false, description = "disabled due to blocked by bug ID")
    public void TC_01() {
        System.out.println("TC_01");

    }

    @Test()
    public void TC_02() {
        System.out.println("TC_02");

    }

    @Test (description = "Jira ID = ")
    public void TC_03_search_with_payment() {
        System.out.println("TC_03");

    }

    @AfterClass(description = "Post-condition for TCs")
    public void afterClass() {
        System.out.println("After Class");
    }
}
