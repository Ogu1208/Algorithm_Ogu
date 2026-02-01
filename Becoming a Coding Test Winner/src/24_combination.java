import java.util.ArrayList;

class Solution24_Combination {

	private static ArrayList<String> resultList = new ArrayList<>();

	public static void main(String[] args) {
		String x = "ABC";
		combinations(0, x.toCharArray(), "");
		System.out.println(resultList); // [A, AB, ABC, AC, B, BC, C]
	}

	private static void combinations(int idx, char[] order, String result) {
		if (result.length() > 0) {
			resultList.add(result);
		}

		for (int i = idx; i < order.length; i++) {
			combinations(i + 1, order, result + order[i]);

		}
	}
}