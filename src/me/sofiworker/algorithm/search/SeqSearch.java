package me.sofiworker.algorithm.search;

/**
 * @author sofiworker
 * @date 2020/8/8
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] a = {-1, 5, 72, 4, -4, 45};

        System.out.println(seqSearch(a, -11));
    }

    private static int seqSearch(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            if (val == a[i]) {
                return i;
            }
        }
        return -1;
    }
}
