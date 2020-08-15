package me.sofiworker.algorithm.horse;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sofiworker
 * @date 2020/8/15
 */
public class Horse {

    // 列数
    private static int X;
    // 行数
    private static int Y;
    private static boolean[] visited;
    private static boolean finished;

    // 计算下一步能走的位置
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> list = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            list.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            list.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            list.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            list.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            list.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            list.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            list.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            list.add(new Point(p1));
        }
        return list;
    }

    // 对下一步走的位置进行递减排序，减少回溯
    public static void sort(ArrayList<Point> ps) {
        ps.sort((o1, o2) -> {
            int size1 = next(o1).size();
            int size2 = next(o2).size();
            return Integer.compare(size1, size2);
        });
    }

    private static void travelChess(int[][] chessBoard, int row, int column, int step) {
        chessBoard[row][column] = step;
        visited[row * X + column] = true;
        ArrayList<Point> points = next(new Point(column, row));
        sort(points);
        while (!points.isEmpty()) {
            Point point = points.remove(0);
            if (!visited[point.y * X + point.x]) {
                travelChess(chessBoard, point.y, point.x, step + 1);
            }
        }
        if (step < X * Y && !finished) {
            chessBoard[row][column] = 0;
            visited[row * X + column] = false;
        }else {
            finished = true;
        }
    }

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        visited = new boolean[X * Y];
        int row = 1;
        int column = 1;
        int[][] chess = new int[X][Y];
        System.out.println(LocalDateTime.now());
        travelChess(chess, row - 1, column - 1, 1);
        System.out.println(LocalDateTime.now());

        for (int[] ints : chess) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
