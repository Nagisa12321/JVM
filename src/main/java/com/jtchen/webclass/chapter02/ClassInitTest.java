package com.jtchen.webclass.chapter02;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/20 15:54
 */
public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 10;
    }



    private static int number = 20;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }
}
