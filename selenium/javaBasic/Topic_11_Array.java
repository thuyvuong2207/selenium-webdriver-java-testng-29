package javaBasic;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Topic_11_Array {
//    public static void main(String[] args) {
//        // declare array
//        // syntax : datatype [] arrayName OR datatype arrayName[]
//        int number[] = {1,2,3,4,5,6,7};
//        int[] student = {12, 7, 0, 33};
//
//        System.out.println(student[3]);
//
//        // khai bao bang For
//        // number.length đếm số phàn tử của array và thao tác với từng index
//        for (int i = 0; i < number.length; i++){
//            System.out.println(number[i]);
//        }
//
//        // allocate memory
//        // set array length as 10
//        int[] number2 = new int[10];
//
//
//        // declare + allocate array
//        int[] number3 = new int[5];
//
//        // declare + init array
//        int[] age1 = {12, 4, 5, 2, 5};
//        int[] age2 = {16, 1, 5, 2, 5};
//
//
//        // ArrayList - add biến vào khi chạy code (Runtime)
//        String studentName = {"Nam", "Long", "An"}
//        ArrayList<String> stdName = new ArrayList<String>();
//        for (String std : studentName) {
//            stdName.add(std);
//        }
//
//
//        // Multi-dimensional array
//        int[][] multiArray = new int[][];
//
//        multiArray[0][0] = [1][5];
//
//        // Method for Array
//        Arrays.asList(multiArray);
//        Arrays.equals(age1,age2);
//        Arrays.fill(number3, 9);
//        Arrays.sort(age1);
//        String std_Name = Arrays.toString(stdName);
//    }

    // Array of Objects
    public static class Student{
        String name;
        int age;
        public Student(String name,int age){
            this.name = name;
            this.age = age;
        }
        public void display(){
            System.out.println("Name : " + name);
            System.out.println("Age : " + age);
        }
        public static void main(String[] args) {
            Student[] students = new Student[3];
            students[0] = new Student("Tuan", 24);
            students[1] = new Student("Lan", 29);
            students[2] = new Student("Hoa", 18);
            for (int i = 0; i < students.length; i++) {
                students[i].display();
            }
        }
    }
}
