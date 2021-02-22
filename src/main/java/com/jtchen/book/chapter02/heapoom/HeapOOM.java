package com.jtchen.book.chapter02.heapoom;

import java.util.ArrayList;

/**2.4.1 java heap 溢出
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 14:10
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
    /*
        java.lang.OutOfMemoryError: Java heap space
        Dumping heap to java_pid13188.hprof ...
        Heap dump file created [30041222 bytes in 0.078 secs]
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	        at java.base/java.util.Arrays.copyOf(Arrays.java:3511)
	        at java.base/java.util.Arrays.copyOf(Arrays.java:3480)
	        at java.base/java.util.ArrayList.grow(ArrayList.java:237)
	        at java.base/java.util.ArrayList.grow(ArrayList.java:244)
	        at java.base/java.util.ArrayList.add(ArrayList.java:454)
	        at java.base/java.util.ArrayList.add(ArrayList.java:467)
	        at com.jtchen.book.chapter02.heapoom.HeapOOM.main(HeapOOM.java:21)
     */
}
