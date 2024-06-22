package javaBasic;


public class Topic_12_String {
    public static void main(String[] args) {
        String s1 = "Cat";
        String s2 = s1;
        String s3 = new String("Cat");

        // == compares both value and memory place
        // used for Primitive
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        // equals compares only value - same sequence of chars
        // used for Reference
        System.out.println(s2.equals(s3));
        System.out.println("-------------");



        // String methods breakdown

        String schoolName = "Automation Testing Advanced";
        String schoolNameUpperCase = "AUTOMATION TESTING ADVANCED";
        String className = "class 79";
        int numClass = 90;
        String tuitionFee = "100.008";
        System.out.println(schoolName);
        System.out.println(schoolNameUpperCase);
        System.out.println(className);
        System.out.println(numClass);
        System.out.println(tuitionFee);



        System.out.println("-------------");

        // length() - return the no. of characters in String
        System.out.println("Length(): " + schoolName.length());
        // charAt() - return char value at specified index
        System.out.println("CharAt(index0): " + schoolName.charAt(0));
        // concat() - concat specified string to the end of this string
        System.out.println("Concat() 2 strings: " + schoolName.concat(" " + className));
        // equals() absolute - verify absolute value of 2 strings
        System.out.println("Equals() absolute: " + schoolName.equals(className));
        // equals() comparative - ignore Uppercase Lowercase, only compare values
        System.out.println("EqualsIgnoreCase() comparative: " + schoolName.equalsIgnoreCase(schoolNameUpperCase));
        // startWith/ endWith/ contains
        System.out.println("startWith(T) : " + schoolName.startsWith("T"));
        // indexOf() - index location of character
        System.out.println("indexOf(Testing): " + schoolName.indexOf("Testing"));
        // subString() - separate substring in String with begin and end index
        System.out.println("subString(5,9): " + schoolName.substring(5,9));
        // split() - separate string base on delimiter
        System.out.println("split(delimiter space): " + schoolName.split(" "));
        // trim() - remove space, new line \n, tab  \t
        System.out.println("trim(): " + schoolName.trim());
        // valueOf() - convert from int/float to string
        String numClassString = String.valueOf(numClass);
        System.out.println("ValueOf() - Value String: " + numClassString);
        // parse() - convert from string to int
        float tuitionFeeInt = Float.parseFloat(tuitionFee);
        System.out.println("parseInt() - Value Integer: " + tuitionFeeInt);

        // dynamic locator
        // Element to change %s String / %d Date / %t Time
        String xpathDynamic = "//button[@id='%s']";
        System.out.println("Login xpath: " + xpathDynamic.format(xpathDynamic, "login"));
        System.out.println("Register xpath: " + xpathDynamic.format(xpathDynamic, "register"));

    }
}
