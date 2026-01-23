import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

	public static void main(String[] args) {
		// int[] result = solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
		// System.out.println(Arrays.toString(result));

		System.out.println(solution("[](){}"));
		System.out.println(solution("}]()[{"));
	}

	public int solution(String s)
	{
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);

			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}
}