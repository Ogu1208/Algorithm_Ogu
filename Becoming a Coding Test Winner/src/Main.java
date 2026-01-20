import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

	public static void main(String[] args) {
		// int[] result = solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
		// System.out.println(Arrays.toString(result));

		System.out.println(solution("ULURRDLLU"));
	}

	static final HashMap<Character, int[]> direction = new HashMap<>();

	static void initDirection() {
		direction.put('U', new int[] {0, 1});
		direction.put('D', new int[] {0, -1});
		direction.put('R', new int[] {1, 0});
		direction.put('L', new int[] {-1, 0});
	}

	static boolean rangeCheck(int nx, int ny) {
		return nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5;
	}

	public static int solution(String dirs) {
		initDirection();

		int x = 0, y = 0;
		HashSet<String> answer = new HashSet<>();

		for (int i = 0; i < dirs.length(); i++) {
			int[] offset = direction.get(dirs.charAt(i));

			int nx = x + offset[0];
			int ny = y + offset[1];

			if (!rangeCheck(nx, ny)) continue;

			answer.add(x + " " + y + " " + nx + " " + ny);
			answer.add(nx + " " + ny + " " + x + " " + y);

			x = nx;
			y = ny;
		}
		return answer.size() / 2;
	}
}