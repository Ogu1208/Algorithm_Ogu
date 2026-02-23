package bfs_dfs;

public class 네트워크 {

	public int solution(int n, int[][] computers) {
		boolean[] visited = new boolean[n];
		int networkCount = 0;

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, computers, visited);
				networkCount++;
			}
		}

		return networkCount;
	}

	private void dfs(int current, int[][] computers, boolean[] visited) {
		visited[current] = true;

		for (int i = 0; i < computers.length; i++) {
			if (computers[current][i] == 1 && !visited[i]) {
				dfs(i, computers, visited);
			}
		}
	}
}
