package com.winterliu;

/**
 * Created by liuwentao on 2019-11-06 20:07
 *
 * 找两个已排好序的不同长度数组的中位数
 *
 *
 */
public class MedianOfTwoSortedArrayOfDifferentLength {

    public double findMedianSortedArrays(int input1[], int input2[]){
        if(input1.length > input2.length){
            return findMedianSortedArrays(input2,input1);
        }

        // 对长度短的进行 low high 操作
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == 0) ? Integer.MAX_VALUE : input2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                // 如果满足这个条件，说明已经找到了最重要的四个值
                if((x + y) % 2 == 0){
                    return ((double)Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY));
                }else{
                    return (double)Math.max(maxLeftX,maxLeftY);
                }
            }else if (maxLeftX > maxLeftY){
                high = partitionX - 1;
            }else{
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args){
        int[] x = new int[]{1,4,7};
        int[] y = new int[]{2,5,7,9,10,11};

        MedianOfTwoSortedArrayOfDifferentLength ms = new MedianOfTwoSortedArrayOfDifferentLength();
        System.out.println(ms.findMedianSortedArrays(x,y));
    }

}
