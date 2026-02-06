import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution31 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 1, 2, 3}));
		System.out.println(solution(new int[] {3, 3, 3, 2, 2, 4}));
		System.out.println(solution(new int[] {3, 3, 3, 2, 2, 2}));
	}

	/**
	 * 폰켓몬 종류만 구하면 해결 가능 -> Set
	 */
	public static int solution(int[] nums) {
		int mine = nums.length / 2;
		HashMap<Integer, Integer> ponketmonCount = new HashMap<>();

		for (int num : nums) {
			ponketmonCount.put(num, ponketmonCount.getOrDefault(num, 0) + 1);
		}

		return Math.min(mine, ponketmonCount.size());
	}

	public static int solution2(int[] nums) {
		int mine = nums.length / 2;

		HashSet<Integer> ponketmonCount = Arrays.stream(nums)
			.boxed().collect(Collectors.toCollection(HashSet::new));

		return Math.min(mine, ponketmonCount.size());
	}
}