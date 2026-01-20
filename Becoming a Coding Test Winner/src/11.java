import java.util.ArrayDeque;
import java.util.Stack;

class Solution11 {

	public int solution(String s) {

		ArrayDeque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}

}