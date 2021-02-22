package com.jtchen.book.chapter03;

import org.junit.Test;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/21 14:24
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /*
        这个成员属性的唯一意义就是占点内存, 以便能在GC日志中查看是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    @Test
    public void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC, objA和objB能否被回收
        System.gc();
    }
}
