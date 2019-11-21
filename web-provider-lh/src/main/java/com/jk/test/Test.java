package com.jk.test;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author 梁浩
 * @Date 2019/11/20
 * @Version V1.0
 **/
public class Test {
    public static void printx(int start, int end) {
        if (start > end) {
            return;
        } else {
            System.out.println(start);
            start++;
            printx(start, end);
        }
    }

    //主函数，程序入口
    public static void main(String[] args) {
        printx(1, 100);
    }

}

