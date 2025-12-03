import java.util.ArrayList;
import java.util.Arrays;

class Solution4 {

	public int[] solution(int[] answers) {
		// 수포자 1 : 12345 반복
		// 수포자 2 : 21232425 반복
		// 수포자 3 : 3311224455 반복
		int[][] patterns = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};
		int[] scores = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == patterns[0][i % patterns[0].length])
				scores[0]++;
			if (answers[i] == patterns[1][i % patterns[1].length])
				scores[1]++;
			if (answers[i] == patterns[2][i % patterns[2].length])
				scores[2]++;
		}

		int maxScore = Arrays.stream(scores).max().getAsInt();
		// maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] == maxScore)
				answer.add(i + 1);
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}