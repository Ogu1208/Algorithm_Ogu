import java.util.Arrays;
import java.util.HashMap;

class Solution27 {

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};

		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
	}

	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		HashMap<String, String> referralMap = new HashMap<>();
		HashMap<String, Integer> income = new HashMap<>();

		for (int i = 0; i < enroll.length; i++) {
			income.put(enroll[i], 0); // 초기화

			if (!referral[i].equals("-")) {
				referralMap.put(enroll[i], referral[i]);
			}
		}

		for (int i = 0; i < seller.length; i++) {
			int profit = amount[i] * 100;
			String name = seller[i];

			while (name != null && profit > 0) {
				int passUp = profit / 10;
				int keep = profit - passUp;

				income.put(name, income.get(name) + keep);

				profit = passUp;
				name = referralMap.get(name);
			}
		}

		for (int i = 0; i < enroll.length; i++) {
			answer[i] = income.getOrDefault(enroll[i], 0);
		}

		return answer;
	}
}