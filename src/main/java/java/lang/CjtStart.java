package java.lang;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/22 16:51
 */
public class CjtStart {
    /*
    JDK 14
    错误: 找不到或无法加载主类 java.lang.CjtStart
    原因: java.lang.ClassNotFoundException: java.lang.CjtStart
     */

    /*
    JDK 1.8
    (安全问题)
    java.lang.SecurityException: Prohibited package name: java.lang
     */
    public static void main(String[] args) {
        System.out.println("hello cjt");
    }
}
