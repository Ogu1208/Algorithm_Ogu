import java.util.HashMap;

class Solution19 {

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();

		for (String name : completion) {
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		for(String name: participant) {
			if (map.getOrDefault(name, 0) == 0) {
				return name;
			}

			map.put(name, map.get(name) - 1);
		}

		return "";
	}
}