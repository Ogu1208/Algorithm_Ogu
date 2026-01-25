import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

class Solution12 {

	public int[] solution(int[] prices) {
		int[] answer = {};
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) { // 주식이 내림
				int j = stack.pop();
				answer[j] = i - j;
			}

			stack.push(i);
		}

		while(!stack.isEmpty()) {
			int j = stack.pop();
			answer[j] = prices.length - j;
		}

		return answer;
	}
}