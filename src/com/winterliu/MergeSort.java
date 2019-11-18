package com.winterliu;

/**
 * Created by liuwentao on 2019-11-18 14:33
 *
 * 归并排序 首先利用递归把一串待排数字不断划分成左右两边，划分到最小时，然后再利用递归不断将排好序的元素块合并
 *
 * 时间复杂度：由于每一层都需要去遍历n个元素，然后根据二叉树的性质，这颗二叉树深度就是以2为底n的对数，所以最后时间复杂度是n*logn
 * 由于需要一个与原数据同样大小的temp数组和一个深度为  以2为底n的对数 的栈空间，所以空间复杂度为：n+logn
 * 又因为merge()函数中存在if判断，不需要跳跃，所以归并排序是稳定的、效率比较高、但是占内存
 */
public class MergeSort {

    public static void main(String[] args){
        int[] arr = new int[]{4,6,2,1,8,2,5,3,7,1};

        MergeSort ms = new MergeSort();
        ms.mergeSort(arr,0,arr.length-1);

        for (int i : arr){
            System.out.print(i + "\t");
        }

    }

    /*
    * mergeSort()函数负责将arr这个数组通过递归不断拆分
    * */
    public void mergeSort(int[] arr,int low,int high){

        int mid = (low + high)/2;
        if (low < high){
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);

            merge(arr,low,mid,high);
        }
    }

    /*
    * merge()函数负责将拆分开的元素块 不断排序后合并
    * */
    public void merge(int[] arr,int low,int mid,int high){
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        while (i <= mid && j <= high){
            if (arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid){
            temp[k++] = arr[i++];
        }

        // 右边
        while (j <= high){
            temp[k++] = arr[j++];
        }

        for (int k2 = 0;k2 < temp.length;k2++){
            arr[k2 + low] = temp[k2];
        }
    }
}
