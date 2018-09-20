package com.xin.leetcode.algorithms;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈[leetcode] 4 两个排序数组的中位数(Median of Two Sorted Arrays)〉
 *
 * @author Xingy
 * @FileName: Solution4Reverse
 * @create 2018/8/10 12:46
 * @since 1.0.0
 */
public class Solution4Reverse {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int nums3[] = new int[]{};
        if ((nums1 == null || nums1.length ==0)
                && (nums2 == null || nums2.length ==0)) {
            return 0;
        }
        if (nums1 == null || nums1.length ==0) {
            nums3 = nums2;
        } else if (nums2 == null || nums2.length ==0) {
            nums3 = nums1;
        } else {
            nums3 = Arrays.copyOf(nums1, nums1.length + nums2.length);
            System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
        }
        Arrays.sort(nums3);
        int mid = nums3.length / 2;
        int left = nums3.length % 2;
        if (left == 0) {
            res = (double) (nums3[mid-1] + nums3[mid]) / 2;
        } else {
            res = nums3[mid];
        }
        return res;
    }
}