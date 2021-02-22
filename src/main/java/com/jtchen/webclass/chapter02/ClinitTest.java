package com.jtchen.webclass.chapter02;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/20 16:16
 */
public class ClinitTest {
    // 任何一个类声明以后, 内部至少存在一个类的构造器, 对应<init>()

    private int a = 1;
    private static int c = 3;

    public static void main(String[] args) {
        int b = 2;
    }

    public ClinitTest() {
        a = 10;
        int d = 20;
    }
}
