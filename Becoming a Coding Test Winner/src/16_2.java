import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 내 풀이
 */
class Solution16_2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(
			new int[] {93, 30, 55},
			new int[] {1, 30, 5}
		)));
	}

	// 이 부분을 변경해서 실행해보세요.
	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answer = new ArrayList<>();

		int n = progresses.length;

		// 각 작업의 배포 가능일 계산
		int[] daysLeft = new int[n];
		for (int i = 0; i < n; i++) {
			daysLeft[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
		}

		int deployCount = 0; // 배포할 작업
		int maxDay = daysLeft[0];

		for (int i = 0; i < n; i++) {
			if (maxDay >= daysLeft[i]) {
				deployCount++;
			} else {
				answer.add(deployCount);
				deployCount = 1;
				maxDay = daysLeft[i];
			}
		}

		if(deployCount > 0) answer.add(deployCount);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}