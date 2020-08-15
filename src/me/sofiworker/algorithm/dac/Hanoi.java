package me.sofiworker.algorithm.dac;

/**
 * @author sofiworker
 * @date 2020/8/14
 *
 * 分治算法 - 汉诺塔问题
 */
public class Hanoi {


    public static void main(String[] args) {
        tower(5, 'A', 'B', 'C');
    }

    private static void tower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从"+a+"->"+c);
        }else {
            // num >= 2 时，总是看成两个
            tower(num - 1, a, c, b);
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            tower(num - 1, b, a, c);
        }
    }
}
