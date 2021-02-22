package com.jtchen.book.chapter03;

import java.util.HashMap;

/**
 * 固定可作为GC Root的对象有什么
 *
 * @author jtchen
 * @version 1.0
 * @date 2021/2/22 14:39
 */
public class GCRootTest {

    /*
     * 1. 在虚拟机栈引用的对象
     *      (当前方法所用到的参数, 局部变量, 临时变量)
     */
    public void fun(String s, HashMap<String, Integer> map) {
        StringBuilder builder = new StringBuilder();
        int a = 1;
    }

    /*
     * 2. 在方法区域类静态属性引用的对象
     *      (java类引用类型静态变量)
     */

    private static Object obj = 831;

    /*
     * 3. 在方法区常量引用的对象
     */

    private static final String s = "test";

    /*
     * 4. 在本地方法栈(JNI)中引用的对象
     * 5. java虚拟机中的内部引用, 如基本数据类型对应的Class对象,
     *    常驻异常对象, 类加载器
     * 6. 所有被同步锁持有的对象
     * 7. 反应虚拟机内部的javabeen等等...
     */
}
