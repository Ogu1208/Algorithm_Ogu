package 배열.Q15_세수의합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15_3Sum_투포인터 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            int sum = nums[i] * -1;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if ((nums[left] + nums[right]) > sum) {
                    right--;
                } else if ((nums[left] + nums[right]) < sum) {
                    left++;
                }
                if ((nums[left] + nums[right]) == sum) {
                    left++;
                    right--;
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
