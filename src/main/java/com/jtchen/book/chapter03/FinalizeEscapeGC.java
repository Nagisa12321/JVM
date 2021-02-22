package com.jtchen.book.chapter03;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/22 15:23
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, I am alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed.");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        // 因为Finalizer线程优先级很低, 暂停5s, 等待它
        Thread.sleep(5000);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, I am dead :(");
        }

        // 对象第二次拯救自己
        SAVE_HOOK = null;
        System.gc();

        // 因为Finalizer线程优先级很低, 暂停5s, 等待它
        Thread.sleep(5000);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, I am dead :(");
        }
    }
    /*
        1. SAVE_HOOK 的 finalize() 确实被垃圾回收器触发过, 并在收集前成功逃脱了
        2. 因为一个对象的 finalize() 只会被虚拟机自动调用一次, 因而第二次没能拯救自己

        3. 建议不使用finalize() 方法, 它不能等同于c++和c的析构函数
     */
}
