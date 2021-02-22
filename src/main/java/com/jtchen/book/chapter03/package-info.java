/**
 * <b>第3章 垃圾收集器和内存分配策略</b><hr/>
 * 3.2.1 引用计数算法<br/>
 * {@link com.jtchen.book.chapter03.ReferenceCountingGC}<br/><br/>
 * 3.2.2 可达性分析算法<br/>
 * - 什么对象可以作为GCRoot? {@link com.jtchen.book.chapter03.GCRootTest} <br/><br/>
 * 3.2.3 再谈引用<br/>
 * - 强引用<br/>
 * - 软引用 {@link java.lang.ref.SoftReference}<br/>
 * - 弱引用 {@link java.lang.ref.WeakReference}<br/>
 * - 虚引用 {@link java.lang.ref.PhantomReference} <br/><br/>
 * 3.2.4 生存还是死亡? <br/>
 */
package com.jtchen.book.chapter03;