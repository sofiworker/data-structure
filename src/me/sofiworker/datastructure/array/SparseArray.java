package me.sofiworker.datastructure.array;

/**
 * @author sofiworker
 * @date 2020/8/2
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] chess = new int[11][11];
        chess[1][2] = 1;
        chess[2][3] = 2;
        chess[7][3] = 2;
        System.out.println("原始数组：");
        for (int[] ints : chess) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        // 先获取数组有效值的个数
        int sum = 0;
        for (int[] ints : chess) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        // 创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        //记录行数
        sparseArray[0][0] = 11;
        //记录列数
        sparseArray[0][1] = 11;
        //记录个数
        sparseArray[0][2] = sum;

        // 再次遍历二维数组，将值放入稀疏数组
        int count = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chess[i][j];
                }
            }
        }

        System.out.println("稀疏数组：");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        int[][] originArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                originArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
            }
        }

        System.out.println("原始的数组：");
        for (int[] ints : originArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }
}
