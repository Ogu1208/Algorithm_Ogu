import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution24 {

	private static Map<String, Integer> menuComboCountList = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {

		for (String order : orders) {
			char[] chars = order.toCharArray();
			Arrays.sort(chars);
			combinations(0, chars, "");
		}

		List<String> result = new ArrayList<>();

		for (int c : course) {
			int maxCount = menuComboCountList.entrySet()
				.stream()
				.filter(e -> e.getKey().length() == c)
				.mapToInt(Map.Entry::getValue)
				.max()
				.orElse(0);

			if (maxCount < 2) continue;

			menuComboCountList.entrySet()
				.stream()
				.filter(e -> e.getKey().length() == c)
				.filter(e -> e.getValue() == maxCount)
				.map(Map.Entry::getKey)
				.forEach(result::add);
		}

		return result.stream()
			.sorted()
			.toArray(String[]::new);
	}

	public static void combinations(int idx, char[] orders, String result) {

		if (!result.isEmpty()) {
			menuComboCountList.put(
				result,
				menuComboCountList.getOrDefault(result, 0) + 1
			);
		}

		for (int i = idx; i < orders.length; i++) {
			combinations(i + 1, orders, result + orders[i]);
		}
	}
}