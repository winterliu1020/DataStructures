package com.winterliu;

/**
 * Created by liuwentao on 2019-11-14 15:13
 *
 * 双端扫描 三分排序，是对快排的一种优化，这里相对于div3ScanSort优化点在于：考虑到假如j指向的元素就是大于pivot的，那么我们想都不想就把j和k的豆子换掉，
 * 这样其实增加了交换的次数，所以我们先对j-- 去找到不大于pivot的豆子，然后再做判断
 */
public class Div3DeScanSort {

    public static void main(String[] args){

        int[] arr = new int[]{4,6,2,1,8,2,5,3,7,1,0,9,-1};

        Div3DeScanSort d3ds = new Div3DeScanSort();
        d3ds.div3DeScanSort(arr,0,arr.length-1);

        for (int i : arr){
            System.out.printf(i + "\t");
        }
    }

    public void div3DeScanSort(int[] arr,int start,int end){

        if (start < end){
            int pivot = arr[start];

            // start~i ： 小于pivot     i~k ： 等于pivot      j~end ： 大于pivot        k~j ：待排元素
            int i = start,k = start+1,j = end;

            OUT_LOOP :while(k <= j){
                // k用于吃豆子，每吃一个就判断应该放到i还是j，还是如果和pivot相等就放在k自己袋子里
                if (arr[k] < pivot){
                    // 交换k,i的豆子
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                    k++;
                    i++;
                }else if (arr[k] > pivot){
                    // 不是单纯的交换k,j的豆子，而是先用j--直到找到不大于pivot的豆子
                    while (arr[j] > pivot){
                        j--;

                        // 这里要注意：j < k 的话，说明k后面一块都是比pivot大的豆子，所以直接break 外部while循环
                        if (j < k){
                            break OUT_LOOP;
                        }
                    }

                    // 如果找到小于pivot的豆子，(首先现在的情况是：k的豆子大于pivot，j的豆子小于pivot)所以j的豆子放到i集合，k的豆子放到j集合
                    if (arr[j] < pivot){
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;

                        temp = arr[k];
                        arr[k] = arr[i];
                        arr[i] = temp;

                        i++;
                        j--;
                        k++;
                    }

                    // 如果找到等于pivot的豆子，只需要j和k交换
                    if (arr[j] == pivot){
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;

                        j--;
                        k++;
                    }

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
            div3DeScanSort(arr,start,i-1);
            div3DeScanSort(arr,j+1,end);
        }

    }

}
