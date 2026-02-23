class Solution38 {

	private static boolean[] visited;
	private static int[][] computer;

	public int solution(int n, int[][] computers) {
		int answer = 0;
		computer = computers;
		visited = new boolean[n]; // 방문 여부 저장

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (!visited[i]) { // 아직 방문하지 않았으면 해당 노드를 시작으로 깊이 우선 탐색
					dfs(i);
					answer++;
				}
			}
		}

		return answer;
	}

	private static void dfs(int now) {
		visited[now] = true;
		for (int i = 0; i < computer[now].length; i++) {
			if (computer[now][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}