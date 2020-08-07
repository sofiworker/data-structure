package me.sofiworker.datastructure.recursion;

/**
 * @author sofiworker
 * @date 2020/8/5
 */
public class RecursionTest {

    public static void main(String[] args) {
//        test(4);
        System.out.println(factorial(31));
    }

    // 打印问题
    private static void test(int n) {
//        if (n > 2) {
//            test(n - 1);
//        }
//        System.out.println("n="+ n);

        if (n > 2) {
            test(n - 1);
        }else {
            System.out.println("n="+ n);
        }
    }

    // 阶乘问题
    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }else {
            return factorial(n - 1) * n;
        }
    }
}
