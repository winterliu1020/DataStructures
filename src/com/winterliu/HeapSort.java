package com.winterliu;

import java.util.Arrays;

/**
 * Created by liuwentao on 2019-11-17 10:07
 *
 * 堆排序（简单选择排序的升级版）
 * 首先需要构建一个大(小)顶堆，然后将堆顶元素和最底部元素交换，每次交换都会确定一个元素
 * 因为简单选择排序是一种很傻的排序，它不会讲前面比较的结果保存下来，所以提出了堆排序这种方法，利用了完全二叉树这种数据结构
 *
 * 难点在于：
 * 1.如何初始化一个大(小)堆
 * 2.在调整第一个、最后一个元素之后如何将剩下的元素恢复成大(小)堆
 */
public class HeapSort {

    public static void main(String[] args){
        int[] arr = new int[]{4,6,2,1,8,2,5,3,7,1};
        HeapSort hs = new HeapSort();
        hs.heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public void heapSort(int[] arr){

        /*
        * 初始化一个大堆
        * i初始化为arr.length/2,是因为arr.length/2 正好是arr这个数组中最后一个有叶子节点的父节点,所以从最后的这个有叶子节点的父节点一直到第一个有叶子节点的父节点，不断去调整节点位置 构建大堆
        * */
        for (int i = arr.length/2;i >= 0;i--){
            heapAdjust(arr,i,arr.length);
        }


        for (int i = arr.length - 1;i > 0;i--){
            swap(arr,0,i); // 初始化大堆之后交换第一个节点和最后一个节点
            heapAdjust(arr,0,i);// 交换之后，重新检查是否符合大堆
        }
    }


    /*
    * 构建堆的过程
    * i是需要构建堆的根节点的序号
    * n是arr数组的长度
    * */
    public void heapAdjust(int[] arr,int i,int n){
        int child,father;
        for (father = arr[i];2*i+1 < n;i = child) {// 2*i+1是i父节点的左孩子节点
            child = 2*i+1;

            // 如果左子树小于右子树，则比较右子树和父节点
            if (child != n-1 && arr[child] < arr[child + 1]){
                child++;
            }

            if (father < arr[child]){
                arr[i] = arr[child];
            }else {
                break;
            }
        }
        arr[i] = father;
    }


    public void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
