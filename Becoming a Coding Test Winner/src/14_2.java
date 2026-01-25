import java.util.Arrays;
import java.util.Stack;

/**
 * 책 풀이 O(N) -> 리스트 초기화 O(N) + X의 모든 합이 100만을 넘지 않음
 */
class Solution14_2 {

	public String solution(int n, int k, String[] cmd) {

		Stack<Integer> deleted = new Stack<>();

		int[] up = new int[n + 2]; // 양 위,아래 끝에 가상 공간 추가
		int[] down = new int[n + 2];

		for (int i = 0; i < n + 2; i++) {
			up[i] = i - 1;
			down[i] = i + 1;
		}

		k++; // 가상 공간을 추가해서 현재 위치인 k의 인덱스를 하나 추가

		for (String c : cmd) {
			if (c.startsWith("C")) {
				down[up[k]] = down[k];
				up[down[k]] = up[k];
				deleted.push(k);
				k = n < down[k] ? up[k] : down[k]; // n < down[k] 인 경우는 가장 아래 행을 삭제했을 때
			} else if (c.startsWith("Z")) {
				int restore = deleted.pop();
				down[up[restore]] = restore;
				up[down[restore]] = restore;
			} else {
				String[] s = c.split(" ");
				int X = Integer.parseInt(s[1]);

				for (int i = 0; i < X; i++) {
					k = s[0].equals("U") ? up[k] : down[k];
				}
			}
		}

		char[] answer = new char[n];
		Arrays.fill(answer, 'O');

		for (int i : deleted) {
			answer[i - 1] = 'X';
		}

		return new String(answer);
	}
}