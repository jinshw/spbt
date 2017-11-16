package com.jinshw.algorithm;

import java.util.Scanner;

/**
 * 问题：有1--9个数填入以下方格中
 * □□□+□□□=□□□
 * Created by Administrator on 2017/8/24 0024.
 */
public class DeepFirstSearch2 {
    private static int[] a = new int[10];
    private static int[] book = new int[10];
    private static int total = 0;

    public static void dfs(int step) {
        // 1、判断边界
        if (step == 10) {
            if (a[1] != 0 && (a[1] * 100 + a[2] * 10 + a[3] + a[4] * 100 + a[5] * 10 + a[6] == a[7] * 100 + a[8] * 10 + a[9])) {
                total++;

//                System.out.println(String.valueOf(a[1] * 100 + a[2] * 10 + a[3]));
//                System.out.println(String.valueOf(a[4] * 100 + a[5] * 10 + a[6]));
//                System.out.println(String.valueOf(a[7] * 100 + a[8] * 10 + a[9]));
                System.out.println(String.valueOf(a[1] * 100 + a[2] * 10 + a[3]) + "+" + String.valueOf(a[4] * 100 + a[5] * 10 + a[6]) + "=" + String.valueOf(a[7] * 100 + a[8] * 10 + a[9]));
                return;
            }
        }


        // 此时站在第step个盒子面前，应该如何放置扑克牌？
        for (int i = 1; i <= 9; i++) {
            if (book[i] == 0) { // i 号扑克牌在手上
                a[step] = i;
                book[i] = 1; // i号扑克牌已经不在手中
                dfs(step + 1);
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
        System.out.println("个数=" + total / 2);
    }
}
