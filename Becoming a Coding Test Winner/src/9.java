import java.util.Stack;

/**
 * logN(2진수 변환)
 */
class Solution9 {

	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(27));
		System.out.println(solution(12345));
	}

	// 이 부분을 변경해서 실행해보세요.
	public static String solution(int decimal) {
		Stack<Integer> stack = new Stack<>();

		while (decimal > 0) {
			int remainder = decimal % 2;
			stack.push(remainder);
			decimal /= 2;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}
}