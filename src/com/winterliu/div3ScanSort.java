package com.winterliu;

/**
 * Created by liuwentao on 2019-11-14 11:23
 *
 * 三分单向扫描 适用于数据集中有很多是等于pivot的元素(其实就是数据集中出现了很多块，每块里面元素是一样的，比如：4，3，2，2，2，5，1，2，2)
 * 这样就分成三份，小于pivot、等于pivot、大于pivot
 */
public class div3ScanSort {

    public static void main(String[] args){

        int[] arr = new int[]{4,6,2,1,8,2,5,3,7,1,0};

        div3ScanSort d3s = new div3ScanSort();
        d3s.div3ScanSort(arr,0,arr.length-1);

        for (int i : arr){
            System.out.printf(i + "\t");
        }
    }

    public void div3ScanSort(int[] arr,int start,int end){

        if (start < end){
            int pivot = arr[start];

            // start~i ： 小于pivot     i~k ： 等于pivot      j~end ： 大于pivot        k~j ：待排元素
            int i = start,k = start+1,j = end;

            while(k <= j){
                // k用于吃豆子，每吃一个就判断应该放到i还是j，还是如果和pivot相等就放在k自己袋子里
                if (arr[k] < pivot){
                    // 交换k,i的豆子
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                    k++;
                    i++;
                }else if (arr[k] > pivot){
                    // 交换k,j的豆子
                    int temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;

                    // 注意这种情况不需要k++
                    j--;
                }else{
                    // 这种情况说明遇到等于pivot，则只需要k++
                    k++;
                }
            }

            // 注意采用三分单向扫描时，最后不需要把pivot换到i-1的位置，因为每个元素都是一个一个吃进来的
            /*
            int temp = pivot;
            arr[start] = arr[i-1];
            arr[i-1] = temp;
             */

            //对小于pivot的集合、大于pivot的集合排序
            div3ScanSort(arr,start,i-1);
            div3ScanSort(arr,j+1,end);
        }

    }

}
