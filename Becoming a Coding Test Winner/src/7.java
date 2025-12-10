import java.util.HashMap;
import java.util.HashSet;

class Solution7 {

	static final HashMap<Character, int[]> dir = new HashMap<>();

	static void initLocation() {
		dir.put('U', new int[]{0, 1});
		dir.put('D', new int[]{0, -1});
		dir.put('R', new int[]{1, 0});
		dir.put('L', new int[]{-1, 0});
	}

	public int solution(String dirs) {
		initLocation();
		int x = 5, y = 5;
		HashSet<String> answer = new HashSet<>();

		for(int i = 0; i < dirs.length(); i++) {
			int[] offset = dir.get(dirs.charAt(i));

			int nx = x + offset[0];
			int ny = y + offset[1];

			if(!rangeCheck(nx, ny)) continue;

			answer.add(x + " " + y + " " + nx + " " + ny);
			answer.add(nx + " " + ny + " " + x + " " + y);

			x = nx;
			y = ny;
		}

		return answer.size() / 2;
	}

	static boolean rangeCheck(int nx, int ny) {
		return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
	}
}