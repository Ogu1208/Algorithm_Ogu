package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Q10845_큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i <N; i++) {
			String command = br.readLine();

			if (command.startsWith("push")) {
				int x = Integer.parseInt(command.split(" ")[1]);
				deque.addLast(x);
			} else if (command.startsWith("pop")) {
				if (deque.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deque.pollFirst()).append('\n');
				}
			} else if (command.startsWith("size")) {
				sb.append(deque.size()).append('\n');
			} else if (command.startsWith("empty")) {
				sb.append(deque.isEmpty() ? 1 : 0).append('\n');
			} else if (command.startsWith("front")) {
				if (deque.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deque.peekFirst()).append('\n');
				}
			} else if (command.startsWith("back")) {
				if (deque.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deque.peekLast()).append('\n');
				}
			}
		}

		System.out.println(sb);
	}
}
