package com.jinshw.algorithm;

import java.util.Scanner;

/**
 * 问题：
 * <p>
 * Created by Administrator on 2017/8/24 0024.
 */
public class DeepFirstSearch {
    private static int[] a = new int[100];
    private static int[] book = new int[100];
    private static int n;
    private static int count = 0;

    private static void dfs(int step) {
        // 边界
        if (step == n + 1) {
            // 输出1-n个数据
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            count++;
            System.out.println();
            return;
        }

        // 此时站在第step个盒子面前，应该如何放置扑克牌？
        for (int i = 1; i <= n; i++) {
            if(book[i] == 0){ // i 号扑克牌在手上
                a[step] = i;
                book[i] =1; // i号扑克牌已经不在手中
                dfs(step+1);
                book[i] = 0;
            }
        }

    }


    public static void main(String[] args) {
        System.out.println("请输入n的值：");
        Scanner scanner = new Scanner(System.in);
        String strn = scanner.next();
        n = Integer.valueOf(strn);
        dfs(1);
        System.out.println("个数="+count);
    }
}
