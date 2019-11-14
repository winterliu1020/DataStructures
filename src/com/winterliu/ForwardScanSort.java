package com.winterliu;

/**
 * Created by liuwentao on 2019-11-14 10:44
 *
 * 单向扫描  这里i,j都是从同一方向开始扫描，
 * start~i 是小于pivot的区间
 * i+1~j 是大于pivot的区间
 * j~end 是待排序区间
 *
 * Note:其实就是一个吃豆子的过程，当j吃到一个大于pivot的豆子 那就直接放到j自己口袋
 * 但是如果吃到一个小于pivot的豆子，因为要放到i的口袋中，所以这里通过i++,然后交换i,j豆子
 */
public class ForwardScanSort {

    public static void main(String[] args){

        int[] arr = new int[]{4,6,2,1,8,2,5,3,7,1};

        ForwardScanSort fss = new ForwardScanSort();
        fss.forwardScanSort(arr,0,arr.length-1);

        for (int i : arr){
            System.out.printf(i + "\t");
        }
    }

    public void forwardScanSort(int[] arr,int start,int end){

        if (start < end){
            int pivot = arr[start];

            // 对i，j进行初始化
            int i = start,j = start+1;

            while (j < arr.length){
                if (arr[j] < pivot){
                    // 说明碰到要放到i口袋里面的豆子 执行i++,再交换i,j豆子
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
                j++;
            }

            // 执行完一次循环之后已经确立i,j的合适位置
            int temp = arr[i];
            arr[i] = pivot;
            arr[start] = temp;

            // 继续递归
            forwardScanSort(arr,start,i-1);
            forwardScanSort(arr,i+1,end);
        }
    }

}
