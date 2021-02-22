package com.jtchen.webclass.chapter02.ignore;

import jdk.nashorn.internal.IntDeque;
import sun.misc.Launcher;
import sun.security.ssl.krb5.Krb5ProxyImpl;

import java.net.URL;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/21 16:01
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("===启动类加载器===");

        // 获取BootstrapClassLoader能够加载的api路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.getPath().substring(1));
        }

        // 从上面路径中随意选择一个类, 看看他的类加载器是什么
        ClassLoader classLoader = Krb5ProxyImpl.class.getClassLoader();
        System.out.println(classLoader);
        // null

        System.out.println("===扩展类加载器===");
        String extDirs = System.getProperty("java.ext.dirs");

        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

        // 从上面路径中随意选择一个类, 看看他的类加载器是什么
        ClassLoader classLoader1 = IntDeque.class.getClassLoader();
        System.out.println(classLoader1);
        // sun.misc.Launcher$ExtClassLoader@4b67cf4d
    }
}
