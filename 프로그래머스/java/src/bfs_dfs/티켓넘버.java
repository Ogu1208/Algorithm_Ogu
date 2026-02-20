package bfs_dfs;

class 티켓넘버 {

	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}

	private int dfs(int[] numbers, int target, int idx, int sum) {
		// 모든 숫자를 다 사용했을 때
		if (idx == numbers.length) {
			return (sum == target) ? 1 : 0;
		}

		// 현재 숫자를 +로 쓰는 경우, -로 쓰는 경우
		int plus = dfs(numbers, target, idx + 1, sum + numbers[idx]);
		int minus = dfs(numbers, target, idx + 1, sum - numbers[idx]);

		return plus + minus;
	}
}