/**
 <b>类的加载过程</b><hr/>
    >> 加载: {@link com.jtchen.webclass.chapter02.HelloLoader}<br/>
        1. 通过一个类的 全限定名称获取定义此类的二进制字节流<br/>
        2. 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构<br/>
        3. 在内存中生成一个代表这个类的java.lang.Class 对象, 作为方法区中这个类的各种数据的
        访问入口<br/><br/>
    >> 链接<br/>
        1. 验证: 确保Class文件的字节流中包含信息符合当前虚拟机要求, 以及被加载类的正确性<br/>
        2. 准备: 为类的变量(不是对象的变量)分配内存平且设置该类变量的默认初始值<br/>
        3. 解析: 将常量池符号转化为直接引用<br/><br/>
    >> 初始化<br/>
        - 初始化阶段就是执行类构造器方法clint()的过程<br/>
        - javac编译器自动收集类中所有类变量的赋值动作, 包括静态代码快=块中的复制东左<br/>
        - 按语句源文件的顺序执行
            {@link com.jtchen.webclass.chapter02.ClassInitTest}<br/>
        - clinit() 不同于类的构造器函数init()
            {@link com.jtchen.webclass.chapter02.ClinitTest}<br/>
        - 子类的clinit()会晚于父类
            {@link com.jtchen.webclass.chapter02.ClinitTest1}<br/>
        - 虚拟机必须保证一个类的clinit()方法在多线程下被同步加锁
          虚拟机在执行一个类的加载的时候只会调用一次clinit() 保证类只加载一次。
            {@link com.jtchen.webclass.chapter02.DeadThreadTest}:
          假若线程1先抢到类的加载, 将会在static块中出不来, 线程2因为类的加载是枷锁的, 正在等待类的加载<br/><br/><br/><br/>
 <b>类加载器</b><hr/>
    >> 分为两大类: 引导类加载器, 自定义类加载器(派生于{@link java.lang.ClassLoader})的类加载器){@link com.jtchen.webclass.chapter02.ClassLoaderTest}
 , {@link com.jtchen.webclass.chapter02.ClassLoaderTest1}<br/><br/>
    >> 启动类加载器(引导类加载器 BootStrap ClassLoader)<br/>
        - 使用c/c++实现, 嵌套在jvm内部<br/>
        - 他用来加载java核心类库 (JAVA_HOME/jre/lib/rt.jar、resources.kar或者sun.boot.class.path)<br/>
          用于提供jvm自身需要的类<br/>
        - 并不继承自CLassLoader 没有父类加载器<br/>
        - 加载扩展类和应用程序加载器, 并且指定为他们的父类<br/>
        - 处于安全考虑, 只加载java, javax, sun等开头的类<br/><br/>
    >> 扩展类加载器(Extension ClassLoader)<br/>
        - 由java编写, 由 {@link sun.misc.Launcher} 的 ExtClassLoader 实现<br/>
        - 派生于{@link java.lang.ClassLoader}<br/>
        - 父类加载器为启动类加载器<br/>
        - 从java.ext.dirs系统属性多指定的目录中加载类库, 或者从jdk的安装目录的jre/lib<br/>
          ext中加载类库, 如果用户创建的jar放在此目录下, 也会被扩展类加载器加载<br/><br/>
    >> 应用程序类加载器(系统类加载器, AppClassLoader)<br/>
        - 由java编写, 由 {@link sun.misc.Launcher} 的AppClassLoader实现<br/>
        - 派生于{@link java.lang.ClassLoader}<br/>
        - 父类加载器为启动类加载器<br/>
        - 负责加载环境变量classpath或者系统属性java.class.path指定路径下的类库<br/>
        - <b>该类加载是程序中默认的类加载器</b>, 一般来说java应用的类都是由它来完成加载<br/>
        - ClassLoader::getSystemClassLoader 可以获取该类加载器<br/><br/>
    >> 用户自定义类加载器:<br/>
        1. 什么时候会定义类的加载器(为什么)<br/>
            -- 隔离加载类: 不同中间件隔离... 避免类的冲突等<br/>
            -- 修改类加载的方式: 根据实际情况, 动态加载<br/>
            -- 扩展加载源: 考虑从数据库中..等等加载<br/>
            -- 防止源码泄露: 加密/解密<br/>
        2. 定义类的加载器的步骤是什么({@link com.jtchen.webclass.chapter02.CustomClassLoader})<br/>
            (1) 继承{@link java.lang.ClassLoader}<br/>
            (2) 重写findClass方法<br/>
            (3) 我们也可继承{@link java.net.URLClassLoader} 避免重现findClass()<br/><br/>
    >> 关于ClassLoader<br/>
        - 获取CLassLoader对象的几种方法: {@link com.jtchen.webclass.chapter02.ClassLoaderTest2}<br/>
 <br/><br/><br/><br/>
 <b>双亲委派机制</b><hr/>
    >> 什么是双亲委派机制?<br/>
        - java虚拟机对class文件的加载采用的是按需加载方式, 也就是说当需要使用该类的时候才会
          将他的class文件加载到内存生成class对象, 而且加载某个类的class文件时, java虚拟机采用的是
          <b>双亲委派模式</b>, 即把请求交由父类处理, 它是一种任务委派模式<br/><br/>
    >> 工作原理:<br/>
        1. 如果一个类加载器收到了类加载的请求, 它并不会自己先去加载, 而是把这个请求委托给父类的加载器
           去执行<br/>
        2. 如果父类加载器还存在其父类加载器, 则应该进一步向上委托, 依次递归请求最终到达顶层的启动类加载器<br/>
        3. 如果父类加载器可以完成类加载任务, 那么就成功返回, 倘若父类加载器无法完成该任务, 子类加载器才会尝试自己去加载<br/>
        eg: {@link com.jtchen.webclass.chapter02.StringTest},{@link java.lang.String}(项目下) <br/>
        eg2: src/main/resources/img/pic1.png <br/><br/>
    >> 优势<br/>
        1. 避免类的重复加载<br/>
        2. 保护程序安全, 防止核心API被随意篡改<br/><br/>
 */
package com.jtchen.webclass.chapter02;

