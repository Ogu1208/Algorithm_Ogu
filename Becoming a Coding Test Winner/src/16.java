import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 내 풀이
 */
class Solution16 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(
			new int[] {93, 30, 55},
			new int[] {1, 30, 5}
		)));
	}

	// 이 부분을 변경해서 실행해보세요.
	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answer = new ArrayList<>();
		ArrayDeque<int[]> deque = new ArrayDeque<>();

		// progress + speed 묶어서 저장
		for (int i = 0; i < progresses.length; i++) {
			deque.addLast(new int[]{progresses[i], speeds[i]});
		}

		int day = 0;
		int deployCount = 0;

		while (!deque.isEmpty()) {
			int[] current = deque.peekFirst();
			int progress = current[0] + current[1] * day;

			if (progress >= 100) {
				deque.pollFirst();
				deployCount++;
			} else {
				if (deployCount > 0) {
					answer.add(deployCount);
					deployCount = 0;
				}
				day++;
			}
		}

		if (deployCount > 0) {
			answer.add(deployCount);
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}