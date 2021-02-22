package com.jtchen.webclass.chapter02;

import org.junit.Test;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/21 16:47
 */
public class ClassLoaderTest2 {

    // 方式一: 获取当前类的ClassLoader
    // clazz.getClassLoader()
    @Test
    public void test1() throws Exception{
        Class<?> clazz = Class.forName("java.lang.String");

        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader);
    }

    // 方式二: 获取当前线程上下文的ClassLoader
    // Thread thread = Thread.currentThread();
    // ClassLoader contextClassLoader = thread.getContextClassLoader();
    @Test
    public void test2() {
        Thread thread = Thread.currentThread();

        ClassLoader contextClassLoader = thread.getContextClassLoader();
        System.out.println(contextClassLoader);
    }

    // 方式三: 获取当前系统的CLassLoader
    // ClassLoader.getSystemClassLoader()
    @Test
    public void test3() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(classLoader);
    }
}
