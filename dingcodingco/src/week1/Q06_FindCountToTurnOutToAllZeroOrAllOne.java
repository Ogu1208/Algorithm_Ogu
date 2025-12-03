package week1;

/**
 * Q.
 * 0과 1로만 이루어진 문자열이 주어졌을 때, 이 문자열에 있는 모든 숫자를 전부 같게 만들려고 한다. 할 수 있는 행동은 문자열에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
 *
 * 예를 들어 S=0001100 일 때,
 *
 * 전체를 뒤집으면 1110011이 된다.
 * 4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
 * 하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
 *
 * 주어진 문자열을 모두 0 혹은 모두 1로 같게 만드는 최소 횟수를 반환하시오.
 *
 * "0001100"
 */
public class Q06_FindCountToTurnOutToAllZeroOrAllOne {

	// 0 에서 1을 마주쳤을 때 뒤집는다 -> 전체를 0으로 만들기 위한 작업
	// 1 에서 0을 마주쳤을 때 뒤집는다 -> 전체를 1로 만들기 위한 작업

	// 1. 0 그룹 / 1 그룹 개수 세는 방법 (그룹 중심)
	// 2. 뒤집는 횟수를 직접 시뮬레이션하며 세기 (뒤집기 중심)
	public static int findCountToTurnOutToAllZeroOrAllOne(String string) {
		int count0 = 0;
		int count1 = 0;

		if (string.charAt(0) == '0')
			count0++;
		else
			count1++;

		for (int i = 1; i < string.length(); i++) {
			if (string.charAt(i) != string.charAt(i - 1)) {
				if (string.charAt(i) == '0')
					count0++;
				else
					count1++;
			}
		}

		return Math.min(count0, count1);
	}

	public static void main(String[] args) {
		String input = "011110";
		int result = findCountToTurnOutToAllZeroOrAllOne(input);
		System.out.println(result);
	}
}
