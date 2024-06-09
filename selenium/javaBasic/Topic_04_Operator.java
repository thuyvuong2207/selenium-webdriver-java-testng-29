package javaBasic;

public class Topic_04_Operator {
    public static void main(String[] args) {
        int number = 10;
        System.out.println(number++);
        // println(number)
        // then + 1

        System.out.println(++number);
        // +1
        // then println(number)

        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }

        String address = "Hanoi";
        if (address != "Hanoi") {
            System.out.println("Address is not the same");
        }

        // Tenary - tam nguyen
        boolean status = (address == "Hanoi") ? true : false;
        System.out.println(status);
    }
}