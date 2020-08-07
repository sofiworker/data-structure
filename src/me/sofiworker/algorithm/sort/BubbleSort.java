package me.sofiworker.algorithm.sort;

/**
 * @author sofiworker
 * @date 2020/8/7
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int[] array = new int[]{3, 9, -1, 10, -2};
        int[] array = new int[]{3, 9, -1, 10, 20};
        for (int i = 0; i < array.length - 1; i++) {
            // 表示是否交换过
            boolean isExchange = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    isExchange = true;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if (!isExchange) {
                break;
            }
        }
//        System.out.println(Arrays.toString(array));
    }
}
