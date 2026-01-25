import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * O(N^2 + M)
 */
class Solution13 {

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int N = board.length;

		ArrayDeque<Integer> basket = new ArrayDeque<>();
		List<Deque<Integer>> stacks = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			stacks.add(new ArrayDeque<>());
		}

		// claw crane 초기화
		for (int[] ints : board) {
			for (int j = 0; j < N; j++) {
				int doll = ints[j];
				if (doll != 0) {
					stacks.get(j).addLast(doll);
				}
			}
		}

		for (int move : moves) {
			if (stacks.get(move - 1).isEmpty()) { // 해당 열의 Stack이 비었을 경우
				continue;
			} else {
				Integer doll = stacks.get(move - 1).pollFirst();
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