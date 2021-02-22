package com.jtchen.book.chapter02.runtimeconstantpooloom;

import org.junit.Test;

import java.util.HashSet;

/**
 * VM args -XX:PermSize=6M -XX:MaxPermSize=6M
 * @author jtchen
 * @version 1.0
 * @date 2021/2/20 14:43
 */
public class RuntimeConstantPoolOOM {

    /*
                JDK6 及以下版本会发生: PermGen Space
                而我用的是jdk14
                原本存放在永久代的字符串常量池已经被移动到java 堆中
                出现java heap space error
             */
    @Test
    public void test1() {
        HashSet<String> set = new HashSet<>();

        for (long i = Long.MIN_VALUE; i < Long.MAX_VALUE; i++) {
            set.add(String.valueOf(i).intern());
        }
    }

    /*
        String::intern 是一个本地方法, 它的作用是如果自从富川常量池中已经包含
        一个等于此String对象的字符串, 则返回代表池中这个字符串的String对象的引用
        否则会创造一个对象并返回引用

        JDK6: 会输出两个false
            >> intern() 会将首次遇见的字符复制到永久代中的字符串常量池中存储,
               然而返回的也是永久代里面这个字符串实例的引用,
               而又StringBuilder创建的字符串对象实例在Java堆之上
               因此绝对不相等

        JDK7及以上版本: 会输出一个true 和 一个false
            >> 字符串常量池已经移动到java堆之中, 那就只需要在常量池里面记录
               以下首次出现的实例引用即可. "just a test"的首次出现就是
               StringBuilder创造的, 因此是同一个

               然而"java" 在StringBuilder创造之前就已经存在了, 因此不是同一个

            >> https://www.zhihu.com/question/51102308/answer/124441115

     */
    @Test
    public void testIntern() throws InterruptedException {
        String str1 = new StringBuilder("just").append(" a test").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }
}
