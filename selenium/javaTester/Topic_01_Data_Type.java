package javaTester;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Topic_01_Data_Type {
    // Java data type
    // I - Primitive
    // Số nguyên:  byte - short - int - long
    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber = 156099;
    long lNumber = 23343433;

    // Số thực  :  float - double (có phần thập phân)
     float fNumber = 9.99f;
     double dNumber = 35.98494900d;

    // Kí tự    :  char (1 kí tự duy nhất)
     char c = 'M';

    // Logic    :  boolean
     boolean status = true;

    // II - Reference
    // Class
    ChromeDriver chromeDriver = new ChromeDriver();
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();

    // Interface
    WebDriver webdriver;
    JavascriptExecutor jsExecutor;

    // Object
    Object name = "Thuy";

    // Array (chứa kiểu nguyên thuỷ/ tham chiếu)
    int[] studentAge = {15, 20, 8};
    String[] studentName = {"Thuy", "Linh"};


    // Collection : List/ Set/ Queue
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentAddress2 = new LinkedList<String>();

    // String - chuỗi kí tự
     String fullname = "Minh";

    /* Khai báo 1 biến để lưu trữ dữ liệu
    - Access Modifier: Phạm vi truy cập (public/ private/ protected/ default)
    - Kiểu dữ liệu
    - Tên biến
    - Giá trị của biến

    Nếu ko gán thì dữ liệu mặc định = 0 hoặc null
     */
    public int studentnumber = 200;
}
