import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 타임아웃된 내 풀이..
 */
class Solution14 {

	public String solution(int n, int k, String[] cmd) {

		char[] result = new char[n];
		Arrays.fill(result, 'O');

		int current = k;
		ArrayList<Integer> table = new ArrayList<>();
		ArrayDeque<Integer> deletedStack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			table.add(i);
		}

		for (String command : cmd) {
			char op = command.charAt(0);

			if (op == 'D' || op == 'U') {
				int num = Integer.parseInt(command.substring(2));
				if (op == 'D') current += num;
				else current -= num;

			} else if (op == 'C') {
				Integer removed = table.remove(current);
				deletedStack.addFirst(removed);

				if (current == table.size()) {
					current--;
				}

			} else if (op == 'Z') {
				Integer value = deletedStack.pollFirst();
				int idx = Collections.binarySearch(table, value);
				if (idx < 0) idx = -idx - 1;

				table.add(idx, value);

				if (idx <= current) {
					current++;
				}
			}
		}

		while (!deletedStack.isEmpty()) {
			result[deletedStack.pollFirst()] = 'X';
		}

		return new String(result);
	}
}