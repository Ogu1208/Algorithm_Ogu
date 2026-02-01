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
		// int[] result = solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
		// System.out.println(Arrays.toString(result));

		// int[][] board = {
		// 	{0, 0, 0, 0, 0},
		// 	{0, 0, 1, 0, 3},
		// 	{0, 2, 5, 0, 1},
		// 	{4, 2, 4, 4, 2},
		// 	{3, 5, 1, 3, 1}
		// };
		//
		// int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		//
		// System.out.println(solution(board, moves));

		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};

		System.out.println(Arrays.toString(solution2(enroll, referral, seller, amount)));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		int N = board.length;

		ArrayDeque<Integer> basket = new ArrayDeque<>();
		List<Deque<Integer>> stacks = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			stacks.add(new ArrayDeque<>());
		}

		// claw crane 초기화
		for (int[] ints : board) {
			for (int j = 0; j < N; j++) {
				int doll = ints[j];
				if (doll != 0) {
					stacks.get(j).addLast(doll);
				}
			}
		}

		for (int move : moves) {
			if (stacks.get(move - 1).isEmpty()) { // 해당 열의 Stack이 비었을 경우
				continue;
			} else {
				Integer doll = stacks.get(move - 1).pollFirst();
				if (!basket.isEmpty() && basket.peekFirst() == doll) {
					basket.pollFirst();
					answer += 2;
				} else {
					basket.addFirst(doll);
				}
			}
		}

		return answer;
	}

	public static int[] solution2(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		HashMap<String, String> referralMap = new HashMap<>();
		HashMap<String, Integer> income = new HashMap<>();

		for (int i = 0; i < enroll.length; i++) {
			income.put(enroll[i], 0);

			if (!referral[i].equals("-")) {
				referralMap.put(enroll[i], referral[i]);
			}
		}

		for (int i = 0; i < seller.length; i++) {
			int profit = amount[i] * 100; // 100원
			String name = seller[i];

			while (name != null && profit > 0) {
				int passUp = profit / 10; // 소수점 버림
				int keep = profit - passUp;

				income.put(name, income.get(name) + keep);

				profit = passUp;
				name = referralMap.get(name);
			}
		}

		for (int i = 0; i < answer.length; i++) {
			answer[i] = income.get(enroll[i]);
		}

		return answer;
	}
}