import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {

	public static int solution(String s) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		int n = s.length();
		s += s;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			boolean valid = true;
			ArrayDeque<Character> deque = new ArrayDeque<>();

			for (int j = i; j < n + i; j++) {
				char c = s.charAt(j);
				if (!map.containsKey(c)) {
					deque.push(c);
				} else {
					if (deque.isEmpty() || deque.pop() != map.get(c)) {
						valid = false;
						break;
					}
				}
			}

			if (valid && deque.isEmpty())
				answer++;
		}

		return answer;
	}
}