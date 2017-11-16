package com.jinshw.algorithm;

import java.util.Scanner;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        Node[] que = new Node[2501];
        int[][] a = new int[51][51];
        int[][] book = new int[51][51];

        for(int index = 0;index<que.length;index++){
            que[index] = new Node();
        }
       /* for(int ai=0;ai<a.length;ai++){
            ai[ai] = 0;
        }*/

        // 定义一个用于表示方向的数组
        int[][] next = {
                {0, 1},//向右走
                {1, 0},//向下走
                {0, -1},//向左走
                {-1, 0}//向上走
        };

        int head, tail;
        int i, j, k, startx, starty, p, q, flag, tx, ty;

        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.next());
        int m = Integer.valueOf(scanner.next());

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                a[i][j] = Integer.valueOf(scanner.next());
            }
        }
        startx = Integer.valueOf(scanner.next());
        starty = Integer.valueOf(scanner.next());
        p = Integer.valueOf(scanner.next());
        q = Integer.valueOf(scanner.next());

        // 队列初始化
        head = 1;
        tail = 1;
        //网队列插入迷宫入口坐标
        que[tail].x = startx;
        que[tail].y = starty;
        que[tail].f = 0;
        que[tail].s = 0;

        tail++;
        book[startx][starty] = 1;

        flag = 0;//用来标记是否达到目标点，0表示暂时还没达到，1表示到达
        // 队列不为空的时候循环
        while (head < tail) {
            //枚举4个方向
            for (k = 0; k <= 3; k++) {
                //计算下一个点的坐标
                tx = que[head].x + next[k][0];
                ty = que[head].y + next[k][1];

                // 判断是否越界
                if (tx < 1 || tx > n || ty < 1 || ty > m) {
                    continue;
                }

                // 判断是否是障碍物或者已经在路径中
                if (a[tx][ty] == 0 && book[tx][ty] == 0) {
                    // 把这个点标记已经走过
                    // 注意宽搜每个点只入队一次，所以和深度不同，不需要将book数组还原
                    book[tx][ty] = 1;
                    // 插入新的点到队列中
                    que[tail].x = tx;
                    que[tail].y = ty;
                    que[tail].f = head;
                    que[tail].s = que[head].s + 1;
                    tail++;

                }

                // 如果到目标点了，停止扩展，任务结束，退出循环
                if (tx == p && ty == q) {
                    // 注意下面两句话的位置千万不要写颠倒了
                    flag = 1;
                    break;
                }

            }
            if (flag == 1) {
                break;
            }
            head++;// 注意这地方千万不要忘记，当一个点扩展结束后，head++才能对后面的点再进行扩展
        }
        // 打印队列中末尾最后一个点（目标点）的步数
        // 注意tail是指队列对尾(即最后一位)的下一个位置，所以这需要-1
        System.out.println(que[tail - 1].s);

    }


}

class Node {
    int x;
    int y;
    int f;
    int s;
}
