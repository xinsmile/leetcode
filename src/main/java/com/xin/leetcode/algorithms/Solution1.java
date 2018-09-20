package com.xin.leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉
 * [leetcode]  1 Two Sum
 * 〈算法 一个数组中两个数相加等于输入的数，返回两个数的下标〉
 *
 * @author Xingy
 * @FileName: com.xin.leetcode.solution.Solution
 * @create 2018/8/9 9:55
 * @since 1.0.0
 */
public class Solution1 {

    /**
     *
     * @deprecated  两个总和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] newNums = new int[nums.length];
        for(int x = 0; x<nums.length; x++) {
            newNums[x] = nums[x];
        }
        Arrays.sort(newNums);
        if (newNums[0] + newNums[1] > target) {
            System.err.println("输入的值过小，找不到两个数之后等于输入值");
            return null;
        }
        if (newNums[newNums.length -1] + newNums[newNums.length - 2] < target) {
            System.err.println("输入的值过大，找不到两个数之后等于输入值");
            return null;
        }
        for(int i = 0; i< nums.length; i++) {
            for(int j = i + 1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res = new int[]{i, j};
                    break;
                }
                if (nums[i] + nums[j] > target) {
                    continue;
                }
            }
        }

        return res;
    }


    public int[] twoSum1(int[] numbers, int target) {
        int [] res = new int[2];
        if(numbers==null||numbers.length<2) {
            return res;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            if(!map.containsKey(target-numbers[i])){
                map.put(numbers[i],i);
            }else{
                res[0]= map.get(target-numbers[i]);
                res[1]= i;
                break;
            }
        }
        return res;
    }

    /**
     * @deprecated  二分法思想
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers==null||numbers.length<2) {
            return res;
        }
        int[] copyList = new int[numbers.length];
        System.arraycopy(numbers,0, copyList, 0, numbers.length);
        Arrays.sort(copyList);

        int low = 0;
        int high = copyList.length -1;
        while (low < high){
            if (copyList[low] + copyList[high] > target) {
                high--;
            } else if (copyList[low] + copyList[high] < target) {
                low++;
            } else {
                res[0] = copyList[low];
                res[1] = copyList[high];
                break;
            }
        }

        int index1 = -1, index2 = -1;
        for (int i= 0; i< numbers.length; i++) {
            if (index1 != -1 && index2 != -1) {
                break;
            }
            if (res[0] == numbers[i] && index1 == -1) {
                index1 = i;
            } else if (res[1] == numbers[i] && index2 == -1) {
                index2 = i;
            }
        }

        res[0] = index1;
        res[1] = index2;
        Arrays.sort(res);
        return  res;
    }
}