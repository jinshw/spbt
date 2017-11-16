package com.jinshw.algorithm;

import java.util.Scanner;

/**
 * 问题：有1--9个数填入以下方格中
 * □□□+□□□=□□□
 * Created by Administrator on 2017/8/24 0024.
 */
public class DeepFirstSearch3 {
    private static int[][] a = new int[51][51];
    private static int[][] book = new int[51][51];
    private static int n, m, p, q, min = 999999;

    public static void dfs(int x, int y, int step) {
        int[][] next = {
                {0, 1},//向右走
                {1, 0},//向下走
                {0, -1},//向左走
                {-1, 0}//向上走
        };

        int tx, ty, k;
        // 1、判断边界
        if (x == p && y == q) {
            if (step < min) {
                min = step;
            }
            return;
        }


        // 枚举4种走法
        for (k = 0; k < 4; k++) {
            // 计算下一个点的坐标
            tx = x + next[k][0];
            ty = y + next[k][1];
            // 判断是否越界
            if (tx < 1 || tx > n || ty < 1 || ty > m) {
                continue;
            }
            // 判断是否为障碍物或者已经在路径中
            if (a[tx][ty] == 0 && book[tx][ty] == 0) {
                book[tx][ty] = 1;// 标记这个点已经走过
                dfs(tx, ty, step + 1);// 开始尝试下一个点
                book[tx][ty] = 0;// 尝试结束，取消这个点的标记
            }

        }
    }

    public static void main(String[] args) {
        int i, j, startx, starty;
        Scanner scanner = new Scanner(System.in);
        n = Integer.valueOf(scanner.next());
        m = Integer.valueOf(scanner.next());
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                a[i][j] = Integer.valueOf(scanner.next());
            }
        }


        startx = Integer.valueOf(scanner.next());
        starty = Integer.valueOf(scanner.next());
        p = Integer.valueOf(scanner.next());
        q = Integer.valueOf(scanner.next());

        book[startx][starty] = 1;
        dfs(startx, starty, 0);

        System.out.println("最短步数=" + min);


    }
}
