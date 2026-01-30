import java.util.HashMap;

/**
 * Map.equals()
 * - key 개수 동일
 * - 모든 key가 서로 동일
 * - 각 key의 value가 equals()로 같음
 */
class Solution20 {

	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0; // 가능한 날 수
		HashMap<String, Integer> wantMap = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			wantMap.put(want[i], number[i]);
		}

		for (int i = 0; i < discount.length - 9; i++) {
			// i번째 날에 가입하면 10일동안 받을 수 있는 품목
			HashMap<String, Integer> discountMap = new HashMap<>();

			for (int j = i; j < i + 10; j++) {
				if (wantMap.containsKey(discount[j])) {
					discountMap.put(
						discount[j],
						discountMap.getOrDefault(discount[j], 0) + 1
					);
				}
			}

			if (discountMap.equals(wantMap)) answer++;
		}

		return answer;
	}
}