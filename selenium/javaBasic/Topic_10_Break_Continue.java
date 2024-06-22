package javaBasic;

import org.testng.annotations.Test;


public class Topic_10_Break_Continue {

    @Test
    public void TC_01_Continue_Basic() {
        // continue - skip a part
        for (int i = 0; i < 10; i++) {

            // exception - not run if i == 5
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }
    }

    @Test
    public void TC_02_Continue_Nested_For() {
        // nested For
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            // mỗi lần chạy For parent sẽ apply cho For child
            for (int j = 1; j <= 5; j++) {
                // exception - not run if j == 4
                if (j == 4) {
                    continue;
                }
                System.out.println("j = " + j);
            }
        }
    }
}
