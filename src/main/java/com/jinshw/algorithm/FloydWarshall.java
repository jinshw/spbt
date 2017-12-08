package com.jinshw.algorithm;

import java.util.Scanner;

/*
* 最短路径
* Floyd-Warshall
* 输入：
*   4 8
    1 2 2
    1 3 6
    1 4 4
    2 3 3
    3 1 7
    3 4 1
    4 1 5
    4 3 12
结果：
    0 2 5 4
    9 0 3 4
    6 8 0 1
    5 7 10 0
* */
public class FloydWarshall {

    public static void main(String[] args) {
        int[][] e = new int[51][51];
        int k, i, j, n, m, t1, t2, t3;
        int inf = 999999;
        Scanner scanner = new Scanner(System.in);
        n = Integer.valueOf(scanner.next());
        m = Integer.valueOf(scanner.next());

        //初始化
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                if (i == j) {
                    e[i][j] = 0;
                } else {
                    e[i][j] = inf;
                }

            }
        }

        // 读入边
        for (i = 1; i <= m; i++) {
            t1 = Integer.valueOf(scanner.next());
            t2 = Integer.valueOf(scanner.next());
            t3 = Integer.valueOf(scanner.next());
            e[t1][t2] = t3;
        }

        //Floyd-Warshall算法核心语句
        for (k = 1; k <= n; k++) {
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (e[i][j] > e[i][k] + e[k][j]) {
                        e[i][j] = e[i][k] + e[k][j];
                    }
                }
            }
        }


        // 输出最终结果
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                System.out.print(e[i][j] +" ");
            }
            System.out.println();
        }

    }

}
