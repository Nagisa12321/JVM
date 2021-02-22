package com.jtchen.webclass.chapter02;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/22 16:16
 */
public class StringTest {
    public static void main(String[] args) {
        // 发现自定义的java.lang.String 用的是AppClassLoader
        // AppClassLoader会向上委托, 找到父类加载器ExtensionClassLoader
        // ExtensionClassLoader向上委托到达引导类加载器, 可以完成加载任务, 成功返回
        String s = new String();
        System.out.println("hello world!");

        // 向上递归委托直至引导类加载器, 最后回到系统类加载器进行加载
        // 还是有一个委托的过程
        StringTest test = new StringTest();
        System.out.println(test.getClass().getClassLoader());
    }
}
