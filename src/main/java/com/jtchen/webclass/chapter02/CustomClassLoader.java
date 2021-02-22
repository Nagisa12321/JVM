package com.jtchen.webclass.chapter02;

import java.io.FileNotFoundException;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/21 16:35
 */
public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 根据name读到内存之中形成二进制数组
            byte[] result = getClassFromCustomPath(name);
            if (result == null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] getClassFromCustomPath(String name) {
        // 从自定义路径中加载指定类: 细节略
        // 如果指定路径的字节码文件进行加密, 则需要在此方法中进行解密操作
        return null;
    }
}
