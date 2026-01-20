import java.util.Arrays;
import java.util.HashSet;

class Solution3 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {2, 1, 3, 4, 1})));
		System.out.println(Arrays.toString(solution(new int[] {5, 0, 2, 7})));
	}

	public static int[] solution(int[] numbers) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		return set.stream().sorted().mapToInt(Integer::intValue).toArray();
	}
}