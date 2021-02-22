package com.jtchen.webclass.chapter02;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/21 15:37
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        // jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d

        // 获取其上层: 扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);
        // jdk.internal.loader.ClassLoaders$PlatformClassLoader@6e8cf4c6

        // 获取其上层: 获取不到引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);
        // null

        // 对于用户自定义类来讲, 类加载器是谁?
        // 使用默认的系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        // jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d

        // String类使用引导类加载器进行加载 --> java核心类库都是使用引导类加载器进行加载
        // 核心类库: java.lang.*
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
        // null

    }
}
