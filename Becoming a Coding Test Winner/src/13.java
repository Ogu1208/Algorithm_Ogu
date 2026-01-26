import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * O(N^2 + M)
 */
class Solution13 {

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int N = board.length;

		ArrayDeque<Integer> basket = new ArrayDeque<>();
		List<Deque<Integer>> lane = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			lane.add(new ArrayDeque<>());
		}

		// claw crane 초기화
		for (int[] ints : board) {
			for (int j = 0; j < N; j++) {
				int doll = ints[j];
				if (doll != 0) {
					lane.get(j).addLast(doll);
				}
			}
		}

		for (int move : moves) {
			if (lane.get(move - 1).isEmpty()) { // 해당 열의 Stack이 비었을 경우
				continue;
			} else {
				Integer doll = lane.get(move - 1).pollFirst();
				if (!basket.isEmpty() && basket.peekFirst() == doll) {
					basket.pollFirst();
					answer += 2;
				} else {
					basket.addFirst(doll);
				}
			}
		}

		return answer;
	}
}