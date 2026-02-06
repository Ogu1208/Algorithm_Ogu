import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

	public static void main(String[] args) {
		int[][] operations1 = {{0, 0, 1}, {0, 1, 2}, {1, 1, 2}};
		System.out.println(Arrays.toString(solution(3, operations1)));
		int[][] operations2 = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};
		System.out.println(Arrays.toString(solution(3, operations2)));

		// String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		// String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		// String[] seller = {"young", "john", "tod", "emily", "mary"};
		// int[] amount = {12, 4, 2, 5, 10};
		//
		// System.out.println(Arrays.toString(solution2(enroll, referral, seller, amount)));
	}

	private static int[] parent;

	private static Boolean[] solution(int k, int[][] operation) {
		parent = new int[k];

		for (int i = 0; i < k; i++) {
			parent[i] = i;
		}

		ArrayList<Boolean> answer = new ArrayList<>();

		// O(NlogN)
		for (int[] op : operation) {
			if (op[0] == 0) { // union 연산
				union(op[1], op[2]);
			} else {    // 같은 집합 equals 연산
				answer.add(find(op[1]) == find(op[2]));
			}
		}

		return answer.toArray(new Boolean[0]);
	}

	// O(logN)
	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return find(parent[x]);
	}

	// O(logN)
	private static void union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);

		parent[y] = rootx;
	}
}