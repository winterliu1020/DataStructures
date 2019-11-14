package com.winterliu;

/**
 * Created by liuwentao on 2019-11-14 09:40
 *
 * 赋值填充 一端挖坑，一端填坑    快速排序的一种
 */
public class FillSort {

    public static void main(String[] args){

        int[] arr = new int[]{4,6,2,1,8,2,5,3};

        FillSort fs = new FillSort();
        fs.fillSort(arr,0,arr.length-1);

        for (int i : arr){
            System.out.printf(i + "\t");
        }
    }

    public void fillSort(int[] arr,int low,int high){

        int i = low,j = high;

        if(low < high){
            int pivot = arr[low];
            while (i < j){
                while (i < j && arr[j] >= pivot){
                    j--;
                }
                // 这里直接赋值，而不交换
                arr[i] = arr[j];

                while (i < j && arr[i] <= pivot){
                    i++;
                }
                arr[j] = arr[i];
            }

            // 跳出循环说明i == j，此时找到合适位置，采用直接填充方式
            arr[i] = pivot;

            fillSort(arr,low,i-1);
            fillSort(arr,i+1,high);
        }
    }
}
