//package com.jtchen.book.chapter02.directmemoryoom;
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
///**
// * vm args: -Xmx20M -XX:MaxDirectMemorySize=10M
// * @author jtchen
// * @version 1.0
// * @date 2021/2/21 14:00
// */
//public class DirectMemoryOOM {
//    private static final int _1MB = 1024 * 1024;
//
//    public static void main(String[] args) throws Exception {
//        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
//        unsafeField.setAccessible(true);
//
//        Unsafe unsafe = (Unsafe) unsafeField.get(null);
//        while (true)
//            unsafe.allocateMemory(_1MB);
//    }
//}
