package com.winterliu;


/**
 * Created by liuwentao on 2019-11-14 17:03
 *
 * 双轴快速排序  和三分单向排序类似，也是i,k,j    只不过这里有两个轴pivot1、pivot2
 * Arrays.sort()方法底层实现原理就是双轴快速排序，只不过它底层不仅仅用到了双轴快速排序，还用到了直接插入排序，对于基本数据类型还用了计数排序
 *
 * 所以分成了： x<pivot1   pivot1<=x<=pivot2    待排序    pivot2<x
 * 最后循环到k==j时，只需要把pivot1和i的豆子换一下      把pivot2和j的豆子换一下
 *
 */
public class DualPivotQuickSort {

    public static void main(String[] args){

        int[] arr = new int[]{4,6,2,1,8,2,5,3,7,1,0,9,-1};

        DualPivotQuickSort dpqs = new DualPivotQuickSort();
        dpqs.dualPivotQuickSort(arr,0,arr.length-1);
        for (int i : arr){
            System.out.printf(i + "\t");
        }
    }

    public void dualPivotQuickSort(int[] arr,int start,int end){
        if (start < end){


            // 最开始如果arr[start] 大于 arr[end]，则两者要互相交换
            if (arr[start] > arr[end]){
                swap(arr,start,end);
            }
            int pivot1 = arr[start],pivot2 = arr[arr.length-1];
            int i = start,j = end,k = start+1;


            OUT_LOOP : while (k < j){
                // 接下来就是k吃一个豆子就判断一次，看它属于哪个阵营
                if (arr[k] < pivot1){
                    // 交换k,i豆子
                    swap(arr,k++,++i);
                }else if (arr[k] <= pivot2){ //    pivot1  <=  a[k] <= pivot2
                    k++;
                }else { //   a[k] >= pivot2

                    // 注意这种情况稍微复杂一些，你需要j-- 直到找到一个豆子是小于pivot2的，这样才不会增加比较次数
                    while (arr[--j] > pivot2){

                        // j-- 之后注意判断现在指向的豆子是不是遇到了k,如果遇到了k说明k后面的豆子都比pivot2大，所以k也不用继续向后面循环了，直接break掉外层循环

                        // 注意其实arr[k]就是当前在比较的豆子，它不是下一个要比较的豆子！所以这里当j==k的时候说明当前比较的豆子后面所有的豆子都比pivot2大，
                        // 而又因为当前比较的豆子arr[k]就是比pivot2要大，所以直接break掉外层循环
                        if (j <= k){
                            break OUT_LOOP;
                        }
                    }

                    // 结束上面这个while循环之后你会找到一个arr[j] <= pivot2的，但是还要判断是不是大于还是小于pivot1，最后决定放到哪里
                    if (arr[j] >= pivot1){
                        // 这种就直接放到pivot1 <= x  <= pivot2 阵营中
                        swap(arr,j,k);
                    }else{
                        // 这种就是：arr[j] <= pivot1,然后我们还需要将arr[k]放到 pivot2 < x 这个阵营中，所以就需要做两次swap
                        swap(arr,j,k);
                        swap(arr,k,++i);

                    }
                    k++;
                }


            }
            // 结束上面while循环中所有豆子各自的三种情况之后，我们最后只需要把pivot1、pivot2放到合适位置，则通过这个循环确立了pivot1、pivot2这两个豆子的位置
            swap(arr,start,i);
            swap(arr,j,end);


            // 最后再对pivot1、pivot2两个豆子划分出来的三个区间进行递归
            dualPivotQuickSort(arr,start,i-1);
            dualPivotQuickSort(arr,i+1,j-1);
            dualPivotQuickSort(arr,j+1,end);
        }


    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




}
