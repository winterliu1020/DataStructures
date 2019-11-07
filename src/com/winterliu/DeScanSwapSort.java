package com.winterliu;

/**
 * Created by liuwentao on 2019-11-06 11:22
 */

/*
* 双端扫描交换（快排的一种方式） Double-End Scan and Swap
* 参考：https://blog.csdn.net/Holmofy/article/details/71168530
*
* @Param items
*           待排数组
*
* */
public class DeScanSwapSort {

    public static void main(String[] args){
        int[] items = new int[]{3,6,9,1,4,2};
        DeScanSwapSort ds = new DeScanSwapSort();
        ds.deScanSwapSort(items,0,items.length - 1);
        ds.show(items);
    }

    public void deScanSwapSort(int[] items,int start,int end){
        if (start < end){
            int pivot = items[start];

            int i = start + 1, j = end;
            while (i <= j){
                while (i <= j && items[i] < pivot)
                    i++;
                while (i <= j && items[j] >= pivot)
                    j--;
                if (i <= j){
                    swap(items,i,j);
                }
            }
            swap(items,start,j);// 当循环结束，说明i > j,也就是i和j相互交叉了，这时才能将中心点交换到中间
            deScanSwapSort(items,start,j - 1);
            deScanSwapSort(items,j+1,end);
        }
    }

    private void swap(int[] items,int i,int j){
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    private void show(int[] items){
        for (int i = 0;i < items.length;i++){
            System.out.println(items[i]);
        }
    }


}
