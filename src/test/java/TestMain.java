import com.xin.leetcode.algorithms.*;

/**
 * 〈一句话功能简述〉
 * 〈测试类〉
 *
 * @author Xingy
 * @FileName: TestMain
 * @create 2018/8/9 13:44
 * @since 1.0.0
 */
public class TestMain {

    public static void main(String[] args) {
        TestMain app = new TestMain();
        app.start();
    }

    private void start() {
//        Solution1 solution = new Solution1();
//        twoSumTest(solution);
//        int[] nums = {3,2,4,5,7,6};
//        int target = 6;
//        solution.twoSum1(nums, target);
//        String s = "wacwwkew1";
//        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.lengthOfLongestSubstring3(s));
//        System.out.println(solution3.lengthOfLongestSubstring(s));
//        int[] nums1 = {1, 3, 6, 8, 10};
//        int[] nums2 = {1, 6, 7, 9, 30};
//        Solution4Reverse solution4 = new Solution4Reverse();
//        solution4.findMedianSortedArrays(nums1, nums2);
//        String s = "wsw";
//        Solution5 solution5 = new Solution5();
//        solution5.longestPalindrome(s);
//        Solution6 solution6 = new Solution6();
//        solution6.convert("PAYPALISHIRING", 3);
//        Solution7Reverse Solution7Reverse = new Solution7Reverse();
//        Solution7Reverse.reverse(1534236469);
//        Solution8 Solution8 = new Solution8();
//        Solution8.myAtoi("-2147483647");
    	Solution10 Solution10 = new Solution10();
//    	boolean istrue = Solution10.isMatch("1232236", "1232*36");
    	boolean istrue = Solution10.isMatch1("1232236", "1232*36");
    	System.out.println("istrue========" + istrue);
    }

    private void twoSumTest(Solution1 solution) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        if (result != null) {
            for(int s : result) {
                System.out.println("s===============" + s);
            }
        }
    }

}