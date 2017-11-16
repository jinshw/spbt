package com.jinshw.algorithm;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/21 0021.
 */
public class Algorithm {
    public static   int [] a = {6,1,2,7,9,3,4,5,10,8};
    public static void main(String[] args){
//        bubbleSort(a);

        quickSort(0,a.length-1);

        for(int i=0;i<a.length;i++){
            System.out.print(a[i] +" ");
        }

//        Scanner sc= new Scanner(System.in);
//        String st = sc.nextLine();//获取输入信息
//        String [] arr =  st.split(" ");
//
//        System.out.println(st);
    }

    /**
     * 冒泡排序
     * 时间复杂度O(N2)
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        int t = 0;
        for(int i=1;i<len;i++){//n个数排序，只用进行n-1次排序
            for(int j=0;j<len-i;j++){
                if(arr[j] < arr[j+1]){
                    t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }

        for(int i=0;i<len;i++){
            System.out.print(arr[i] +" ");
        }
    }

    /**
     * 快速排序
     * 时间复杂度O(nlogn)
     * @param left
     * @param right
     */
    public static void quickSort(int left,int right){
        int i,j,temp,t;
        if(left >right){
            return;
        }
        temp = a[left]; // 基准数
        i = left;
        j = right;
        while (i!=j){

            // 从右向左查找
            while (a[j] >= temp && i<j){
                j--;
            }

            // 从左向右查找
            while (a[i] <= temp && i<j){
                i++;
            }

            // 交换两个数在数组中的位置
            if(i<j){
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        //最终将基准数归位
        a[left] = a[i];
        a[i] = temp;

        quickSort(left,i-1);
        quickSort(i+1,right);

    }
}
