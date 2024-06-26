package javaBasic;

public class Topic_05_Primitive_Casting {
    public static void main(String[] args) {
        // Implicit - ngầm định
        byte bNumber = 6;
        System.out.println(bNumber);
        short sNumber = bNumber;
        System.out.println(sNumber);
        int iNumber = sNumber;
        System.out.println(iNumber);
        long lNumber = iNumber;
        System.out.println(lNumber);
        float fNumber = lNumber;
        System.out.println(fNumber);
        double dNumber = fNumber;
        System.out.println(dNumber);

        // Cast - tường minh
        dNumber = 65789300;
        System.out.println(dNumber);

        fNumber = (float) dNumber;
        System.out.println(fNumber);
    }
}