package testng;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Topic_01_Sample {

        // Unit tests
        @Test
        public void testGetRandomNumber() {
            Topic_01_Sample sample = new Topic_01_Sample();
            int randomNumber = sample.getRandomNumber();
            Assert.assertTrue(randomNumber >= 0 && randomNumber < 1000000);
        }

    // Component
    private int getRandomNumber(){
        return new Random().nextInt(1000000);
    }
}
