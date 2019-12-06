package com.winterliu;

/**
 * Created by liuwentao on 2019-12-06 08:43
 *
 * 洗牌算法
 */
public class Fisher_Yates_shuffle {

    public static void main(String[] args) {
        // 其实就是把一个数组中的元素随机排序，思路是：i从n-1 downto 1,j是0 到 i之间一个随机数，产生一个j之后就把j和i位置上的数交换，然后进行下一轮迭代
        int[] arr = new int[]{1,2,3,4,5,6,7,8};

        int n = arr.length;
        System.out.print("原始数组： ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }

        for (int i = n - 1; i > 0; i--) {
            int j = (int)(Math.random() * i + 1);

            // 再交换i,j位置的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.print("\n洗牌后数组： ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
