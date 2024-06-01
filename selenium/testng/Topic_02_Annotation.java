package testng;

import org.testng.annotations.*;

public class Topic_02_Annotation {
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("afterGroups");
    }

    @Test
    public void test01() {
        System.out.println("Test 01");
    }
    @Test
    public void test02() {
        System.out.println("Test 02");
    }
    @Test (enabled = false, description = "ID Jira ticket")
    public void test03() {
        System.out.println("Test 03");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
}
