package java.lang;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/22 16:18
 */
public class String {
    // 类的加载第三个阶段: 初始化
    static {
        System.out.println("i am string's static");
    }

    /*
    错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
        public static void main(String[] args)

    否则 JavaFX 应用程序类必须扩展javafx.application.Application
     */
    // 因为该类由引导类加载器加载
    public static void main(String[] args) {
        System.out.println("hello String");
    }
}
