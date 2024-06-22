package javaBasic;

import org.testng.annotations.Test;

import java.util.Scanner;


public class Topic_09_While_Do_While {

    @Test
    public void TC_01_While_Do_While() {
        int i = 0;
        // for
        // run code block inside for. Then i++
        for (i = 0; i < 10; i++) {
            System.out.println("For" + i);
            if (i == 3) {
                break;
            }
        }
        System.out.println("--------------------------------");
    }
    @Test
    public void TC_02_While() {
        // while
        // run code block. Run i++ then break
        int i = 0;
        while (i < 10) {
            System.out.println("While" + i);
            i++;

            if (i == 3) {
                break;
            }
        }
        System.out.println("--------------------------------");
    }

    @Test
    public void TC_03_Do_While() {
        // do - while
        int i = 0;
        do {
            System.out.println("Do-While" + i);
            i++;
        } while (i < 10);
    }
}
