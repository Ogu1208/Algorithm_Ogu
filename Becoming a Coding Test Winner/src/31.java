import java.util.HashMap;

class Solution31 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 1, 2, 3}));
		System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
		System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
	}
	
	public static int solution(int[] nums) {
		int answer = 0;
		int mine = nums.length / 2;
		HashMap<Integer, Integer> ponketmonCount = new HashMap<>();

		for (int num : nums) {
			ponketmonCount.put(num, ponketmonCount.getOrDefault(num, 0) + 1);
		}

		return Math.min(mine, ponketmonCount.size());
	}
}