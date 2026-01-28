import java.util.HashMap;
import java.util.HashSet;

class Solution18 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 4, 8}, 6));
		System.out.println(solution(new int[] {2, 3, 5, 9}, 10));
	}

	// 이 부분을 변경해서 실행해보세요.
	private static boolean solution(int[] arr, int target) {
		HashSet<Integer> hashSet = new HashSet<>();

		for (int num : arr) {
			if (hashSet.contains(target - num)) {
				return true;
			} else {
				hashSet.add(num);
			}
		}

		return false;
	}
}