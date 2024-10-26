package 배열;

/**
 * 시간복잡도 : O(n^2)
 * 모두 탐색하는 방식
 */
public class Q1_TwoSum_브루트포스_W1 {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    output = new int[]{i, j};
                    return output;
                }
            }
        }
        return output;
    }
}
