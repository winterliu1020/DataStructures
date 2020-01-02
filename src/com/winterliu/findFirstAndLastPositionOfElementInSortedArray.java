package com.winterliu;

/**
 * Created by liuwentao on 2020-01-02 14:54
 */
public class findFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] res = searchRange(new int[]{0,0,1,2,2,2,2,3,3,4,4,4,5,6,6,7,7,8,9,9,10},5);
        System.out.println(res[0] + ":" + res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        // 升序排好了序的整形数组，让你找target开始和结束的位置；要求时间复杂度logn;没找到则是-1

        // 以下是我写的代码，通过了四分之三的测试用例，对于找右边界那部分代码还有问题,我花了很多时间来处理边界问题上，还是没能成功
        /*
        if (nums.length == 1) {
            if (nums[0] == target)
                return new int[]{0,0};
            return new int[]{-1,-1};
        }

        int lo = 0, hi = nums.length - 1, mid = 0; // 利用这里的lo和hi在大的二分查找里面找到target
        int lo1 = 0, hi1 = 0, mid1 = 0; // 找左边界要用的变量
        int lo2 = 0, hi2 = 0, mid2 = 0; // 找右边界要用的变量
        int left = 0, right = 0; // 左右边界
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (target == nums[mid]) { // 相等则说明定位到了target，接下来就只要确定左右边界就行了
                // 还得用二分法去lo~mid-1、mid+1~hi两个区间中分别找到左右边界
                // 找左边界

                lo1 = lo;
                hi1 = mid - 1;
                while (lo1 < hi1) {
                    mid1 = (lo1 + hi1) / 2;
                    if (target == nums[mid1]) {
                        hi1 = mid1;
                    } else{
                        lo1 = mid1 + 1;
                    }
                }


                if (hi1 < 0) {
                    left = 0;
                } else {
                    if (nums[hi1] != target) { // 如果在左半部分没有找到target，则让left=mid
                    left = mid;
                    } else { // 如果找到了，则让left = lo1;
                        left = lo1; // 确定左边界
                    }
                }


                // 找右边界
                lo2 = mid + 1;
                hi2 = hi;
                while (lo2 < hi2) {
                    mid2 = (lo2 + hi2) / 2;
                    System.out.println("---" + hi2 + " :" + lo2);
                    if (hi2 - lo2 == 1) {
                        if (nums[hi2] == target) {
                            right = hi2;
                            System.out.println(hi2);
                            break;
                        } else {
                            right = lo2;
                            break;
                        }
                    }
                    if (target == nums[mid2]) {
                        lo2 = mid2;
                    } else {
                        hi2 = mid2 - 1;
                    }
                }

                if (nums[right] != target) { // 如果在右半部分没有找到target，则让right=mid
                    right = mid;
                }

                System.out.println(left + ":" + right);
                //返回左右边界
                return new int[]{left,right};
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return new int[]{-1,-1};*/


        // 以下为参考别人的代码
        int start = 0;
        int end = nums.length - 1;
        int[] ans = {-1, -1};
        if (nums.length == 0) {
            return ans;
        }

        // 找左边界
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                int n = mid > 0 ? nums[mid - 1] : Integer.MIN_VALUE;
                if (target > n || mid == 0) { // target > n 说明mid就是left了;mid==0也应该直接将left=mid
                    ans[0] = mid;
                    break;
                }
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // 找右边界
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                int n = mid < nums.length - 1 ? nums[mid + 1] : Integer.MAX_VALUE;
                if (target < n || mid == nums.length - 1) { // target < n 说明mid已经是右边界了；mid==nums.length-1也应该直接将right=mid
                    ans[1] = mid;
                    break;
                }
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
