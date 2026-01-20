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

	// N이 1이 될 때까지 2로 계속 나눔 -> O(logN)
	// - StringBuilder 사용 : O(logN)
	// - String 사용 : O((logN)^2)
	public static String solution(int decimal) {
		Stack<Integer> stack = new Stack<>();

		while(decimal > 0) {
			stack.push(decimal % 2);
			decimal /= 2;
		}

		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}
}