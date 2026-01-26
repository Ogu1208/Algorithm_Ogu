import java.util.ArrayDeque;
import java.util.Queue;

class Solution15 {

	public static void main(String[] args) {
		System.out.println(solution(5, 2));
	}

	// 이 부분을 변경해서 실행해보세요.
	private static int solution(int N, int K) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			queue.addLast(i + 1);
		}

		while (queue.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				queue.addLast(queue.pollFirst());
			}
			queue.pollFirst();
			System.out.println(queue.toString());
		}
		System.out.println(queue.toString());
		return queue.pollFirst();
	}
}