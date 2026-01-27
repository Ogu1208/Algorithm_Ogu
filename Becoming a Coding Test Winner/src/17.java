import java.util.ArrayDeque;

/**
 *
 */
class Solution17 {

	public String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "Yes";

		ArrayDeque<String> cards1Queue = new ArrayDeque<>();
		ArrayDeque<String> cards2Queue = new ArrayDeque<>();
		ArrayDeque<String> goalQueue = new ArrayDeque<>();

		for (int i = 0; i < cards1.length; i++) {
			cards1Queue.addLast(cards1[i]);
		}

		for (int i = 0; i < cards2.length; i++) {
			cards2Queue.addLast(cards2[i]);
		}

		for (int i = 0; i < goal.length; i++) {
			goalQueue.addLast(goal[i]);
		}

		while (!goalQueue.isEmpty()) {
			if (!cards1Queue.isEmpty() && cards1Queue.peekFirst().equals(goalQueue.peekFirst())) {
				cards1Queue.pollFirst();
				goalQueue.pollFirst();
			} else if (!cards2Queue.isEmpty() && cards2Queue.peekFirst().equals(goalQueue.peekFirst())) {
				cards2Queue.pollFirst();
				goalQueue.pollFirst();
			} else {
				answer = "No";
				break;
			}
		}

		return answer;
	}
}