package com.jtchen.book.chapter02.javamethodareaoom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author jtchen
 * @version 1.0
 * @date 2021/2/21 13:50
 */
public class JavaMethodAreaOOM {
    /*
        jdk8以后元空间代替了永久代的位置
        在默认设置下, 几乎无法迫使方法区发生溢出异常
     */
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(objects, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject{

    }
}
