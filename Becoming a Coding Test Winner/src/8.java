import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution8 {

	boolean solution(String s) {
		boolean answer = true;

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}