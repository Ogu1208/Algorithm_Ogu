import java.util.Arrays;
import java.util.HashSet;

class Solution32 {

	public static void main(String[] args) {
		// 테스트 1
		int n1 = 3;
		String[] words1 = {
			"tank", "kick", "know", "wheel", "land",
			"dream", "mother", "robot", "tank"
		};
		System.out.println("Test1: " + Arrays.toString(solution(n1, words1)));
		// 기대값: [3, 3]

		// 테스트 2
		int n2 = 5;
		String[] words2 = {
			"hello", "observe", "effect", "take", "either",
			"recognize", "encourage", "ensure", "establish",
			"hang", "gather", "refer", "reference",
			"estimate", "executive"
		};
		System.out.println("Test2: " + Arrays.toString(solution(n2, words2)));
		// 기대값: [0, 0]

		// 테스트 3
		int n3 = 2;
		String[] words3 = {
			"hello", "one", "even", "never",
			"now", "world", "draw"
		};
		System.out.println("Test3: " + Arrays.toString(solution(n3, words3)));
		// 기대값: [1, 3]
	}

	public static int[] solution(int n, String[] words) {
		HashSet<String> usedWords = new HashSet<>();
		String previous = words[0];
		usedWords.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			if (usedWords.contains(words[i]) || previous.charAt(previous.length() - 1) != words[i].charAt(0)) {
				return new int[] {(i % n) + 1, (i / n) + 1};
			}

			usedWords.add(words[i]);
			previous = words[i];
		}

		return new int[] {0, 0};
	}
}