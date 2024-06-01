package orders;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Order_01_Search {

    @BeforeMethod (alwaysRun = true)
    public void beforeMethod() {
        System.out.println("before method check run");
    }

    @Test (groups = {"category", "order"})
    public void precondition()  {

    }
    @Test (groups = "orders")
    public void testSearchWithDate() {

    }

    @Test (groups = "orders")
    public void testSearchWithBilling() {
    }

    @AfterMethod
    public void afterMethodCheck() {
        System.out.println("after method check run");
    }
}
