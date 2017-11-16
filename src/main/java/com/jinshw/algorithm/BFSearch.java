package com.jinshw.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 图的广度优先遍历
 * 1、邻接矩阵保存保存边
 * 2、队列实现存储值
 */
public class BFSearch {


    public static void main(String[] args) {
        ArrayList vList;//存储点值的链表
        BFSNode[] que = new BFSNode[51];
        int[][] edges = new int[51][51];//存储边的邻接矩阵
        int numEdges;// 边的数目

        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.valueOf(scanner.next());
        Integer m = Integer.valueOf(scanner.next());
        Integer start = Integer.valueOf(scanner.next());
        Integer end = Integer.valueOf(scanner.next());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    edges[i][j] = 0;
                } else {
                    edges[i][j] = 9999;
                }
            }
        }
        Integer a, b;
        for (int i = 1; i <= m; i++) {
            a = Integer.valueOf(scanner.next());
            b = Integer.valueOf(scanner.next());
            edges[a][b] = 1;
            edges[b][a] = 1;
        }

       /* for (int i = 1; i <= n; i++) {
            for (int j = 1; j < edges.length; j++) {
                System.out.print(edges[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }*/

        int[] book = new int[51];
        for (int i = 0; i < 51; i++) {
            book[i] = 0;
        }

        for (int i = 0; i < 30; i++) {
            que[i] = new BFSNode();
        }

        // 初始化队列
        int head = 1, tail = 1;
        que[tail].x = start;
        que[tail].s = 0;
        tail++;
        book[start] = 1;//标记start号城市已在队列中

        int cur;
        int flag = 0;
        // 当队列不为空的时候循环
        while (head < tail) {
            cur = que[head].x;
            for (int j = 1; j <= n; j++) {
                if (edges[cur][j] != 9999 && book[j] == 0) {
                    que[tail].x = j;
                    que[tail].s = que[head].s + 1;
                    tail++;
                    book[j] = 1;
                }
                //如果到达目标城市，停止扩展，任务结束，退出循环
                if (que[tail - 1].x == end) {
                    flag = 1;
                    break;
                }

            }

            if (flag == 1) {
                break;
            }
            head++;
        }
        System.out.println("最后转机次数:" + que[tail - 1].s);

    }
}

class BFSNode {
    int x;//城市编号
    int s;//转机次数
}

