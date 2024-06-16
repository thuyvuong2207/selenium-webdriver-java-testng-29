package javaBasic;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Topic_08_For_ForEach {

    // Array / List / Set / Queue
    String[] cityName = {"Hanoi", "Da Nang", "Hue", "HoiAn", "Hochiminh"};

    @Test
    public void TC_01_For_Iterate() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println("--------------------------------");

        // Option 1: for
        // Combine with if. Only when "if" condition meets, action is executed
        for (int i = 0; i < cityName.length; i++) {
            if (cityName[i].equals("HoiAn")) {
                System.out.println("Hoi An selected");
                break;
                // if add "break", code stops once find the condition meets
                // if not add "break", code continues to run for the remaining variables
            }
        }

        System.out.println("--------------------------------");

        // Reverse for
        for (int i = 10; i > 0; i--){
            System.out.println(i);
        }
    }

    public void TC_02_ForEach() {
        // Option 2: for each
        // use to run over all variables of cityName. Doesn't stop until run all.
        for (String eachCityName : cityName) {
            System.out.println(eachCityName);
        }

        System.out.println("--------------------------------");

        // for each with an increasing variables as index - NOT RECOMMENDED
        int y = 0;
        for (String eachCityName : cityName) {
            if (cityName[y].equals("Hochiminh")) {
                System.out.println("HCM");
                System.out.println(eachCityName);
                break;
            }
            y++;
        }

        // Java collection
        // Class: ArrayList/ LinkedList/ Vector
        // Interface: List / Set/ Queue
        List<String> cityAddress = new ArrayList<String>();

        // Compile
        cityAddress.add("Bac Giang");
        cityAddress.add("Ha Tinh");
        cityAddress.add("Phu Tho");

        // Runtime
        for (String city : cityName) {
            cityAddress.add(city);
        }
        System.out.println(cityAddress.size());

    }
}
