package com.winterliu;

/**
 * Created by liuwentao on 2019-11-07 08:10
 *
 * 这里用传统的快速排序 利用 i j 依次交换
 */
public class TraditionQuickSort {

    public static void main(String[] args){
        int[] input = new int[]{4,2,6,8,1,2};
        TraditionQuickSort tqs = new TraditionQuickSort();
        tqs.QuickSort(input,0,input.length-1);

        tqs.print(input);
    }

    // 快速排序
    public void QuickSort(int[] input,int low,int high){

        int i = low,j = high;

        // 注意下面这个递归的终止条件
        if(i > j)
            return;

        while (i < j){
            while (i < j && input[j] >= input[i]){
                j--;
            }
            swap(input,i,j);
            while (i < j && input[i] <= input[j]){
                i++;
            }
            swap(input,i,j);
        }

        // 退出循环 说明 i==j
        QuickSort(input,low,i-1);
        QuickSort(input,i+1,high);
    }

    public void swap(int[] input,int i,int j){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    // 打印数组
    public void print(int[] input){
        for(int i = 0;i < input.length;i++){
            System.out.print(input[i] + "    ");
        }
    }
}
