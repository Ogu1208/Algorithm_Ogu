import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

class Solution2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {4, 2, 2, 1, 3, 4})));
		System.out.println(Arrays.toString(solution(new int[] {2, 1, 1, 3, 2, 5, 4})));
	}

	// 이 부분을 변경해서 실행해보세요.
	private static int[] solution(int[] arr) {
		// 1. Stream<Integer>로 바꿔서 중복 없애고 Integer[]로 반환하기
		Integer[] array = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
		// 2. 내림차순 정렬
		Arrays.sort(array, Collections.reverseOrder());
		// 3. int[] 배열로 다시 바꾸기
		return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
	}

	// 스트림이 기억나지 않는 경우
	private static int[] solution2(int[] arr) {
		// 중복값 제거 + 내림차순 정렬
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for (int num : arr) {
			set.add(num);
		}

		return set.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
