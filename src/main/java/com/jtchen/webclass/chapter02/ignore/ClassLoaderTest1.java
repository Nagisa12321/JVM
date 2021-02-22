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
        System.out.println("===�����������===");

        // ��ȡBootstrapClassLoader�ܹ����ص�api·��
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.getPath().substring(1));
        }

        // ������·��������ѡ��һ����, �����������������ʲô
        ClassLoader classLoader = Krb5ProxyImpl.class.getClassLoader();
        System.out.println(classLoader);
        // null

        System.out.println("===��չ�������===");
        String extDirs = System.getProperty("java.ext.dirs");

        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

        // ������·��������ѡ��һ����, �����������������ʲô
        ClassLoader classLoader1 = IntDeque.class.getClassLoader();
        System.out.println(classLoader1);
        // sun.misc.Launcher$ExtClassLoader@4b67cf4d
    }
}
