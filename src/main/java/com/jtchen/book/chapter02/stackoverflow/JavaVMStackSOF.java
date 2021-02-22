package com.jtchen.book.chapter02.stackoverflow;

import org.junit.Test;

/**
 * 2.4.2 虚拟机栈和本地方法栈溢出
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 14:27
 */
public class JavaVMStackSOF {
    private int stackLength = 0;

    public void stackLeak1() {
        stackLength++;
        stackLeak1();
    }

    /*
     * StackOverFlow情况一:
     * 因为超过相应堆栈深度导致
     *
     * VM args: -Xss128k
     */
    @Test
    public void test1() {
        JavaVMStackSOF sof = new JavaVMStackSOF();

        try {
            sof.stackLeak1();
        } catch (Throwable e) {
            System.out.println("stack length: " + sof.stackLength);
            System.err.println(e);
        }
    }

    /*
     * stack over flow 情况二
     * 由于栈帧太大导致
     */
    @Test
    public void test2() {
        JavaVMStackSOF sof = new JavaVMStackSOF();

        try {
            sof.stackLeak2();
        } catch (Throwable e) {
            System.out.println("stack length: " + sof.stackLength);
            System.err.println(e);
        }
    }

    public void stackLeak2() {
        long unused1, unused2, unused3, unused4, unused5, unused6, unused7, unused8, unused9, unused10,
                unused11, unused12, unused13, unused14, unused15, unused16, unused17, unused18, unused19, unused20,
                unused21, unused22, unused23, unused24, unused25, unused26, unused27, unused28, unused29, unused30,
                unused31, unused32, unused33, unused34, unused35, unused36, unused37, unused38, unused39, unused40,
                unused41, unused42, unused43, unused44, unused45, unused46, unused47, unused48, unused49, unused50,
                unused51, unused52, unused53, unused54, unused55, unused56, unused57, unused58, unused59, unused60,
                unused61, unused62, unused63, unused64, unused65, unused66, unused67, unused68, unused69, unused70,
                unused71, unused72, unused73, unused74, unused75, unused76, unused77, unused78, unused79, unused80,
                unused81, unused82, unused83, unused84, unused85, unused86, unused87, unused88, unused89, unused90,
                unused91, unused92, unused93, unused94, unused95, unused96, unused97, unused98, unused99, unused100;

        stackLength++;
        stackLeak2();

        unused1 = unused2 = unused3 = unused4 = unused5 = unused6 = unused7 = unused8 = unused9 = unused10 =
                unused11 = unused1 = unused13 = unused14 = unused15 = unused16 = unused17 = unused18 = unused19 = unused20 =
                        unused21 = unused22 = unused23 = unused24 = unused25 = unused26 = unused27 = unused28 = unused29 = unused30 =
                                unused31 = unused32 = unused33 = unused34 = unused35 = unused36 = unused37 = unused38 = unused39 = unused40 =
                                        unused41 = unused42 = unused43 = unused44 = unused45 = unused46 = unused47 = unused48 = unused49 = unused50 =
                                                unused51 = unused52 = unused53 = unused54 = unused55 = unused56 = unused57 = unused58 = unused59 = unused60 =
                                                        unused61 = unused62 = unused63 = unused64 = unused65 = unused66 = unused67 = unused68 = unused69 = unused70 =
                                                                unused71 = unused72 = unused73 = unused74 = unused75 = unused76 = unused77 = unused78 = unused79 = unused80 =
                                                                        unused81 = unused82 = unused83 = unused84 = unused85 = unused86 = unused87 = unused88 = unused89 = unused90 =
                                                                                unused91 = unused92 = unused93 = unused94 = unused95 = unused96 = unused97 = unused98 = unused99 = unused100 = 0;


    }

    /*
        要在32位系统上运行
        创建线程导致的内存溢出异常
        Vm args : -Xss2M

        [54.954s][warning][os,thread] Failed to start thread - _beginthreadex failed (EACCES) for attributes: stacksize: 2048k, flags: CREATE_SUSPENDED STACK_SIZE_PARAM_IS_A.
     */
    @Test
    public void test3() {
        while (true) {
            new Thread(() -> {
                dontStop();
            }).start();
        }
    }

    private void dontStop() {
        while (true);
    }

}
