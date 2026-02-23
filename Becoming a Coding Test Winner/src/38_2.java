class Solution38_2 {

	private static int[] parent;

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		parent[x] = find(parent[x]); // 경로 압축
		return parent[x];
	}

	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}

	public int solution(int n, int[][] computers) {
		parent = new int[n];

		// 자기 자신을 부모로 초기화
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		// 연결된 컴퓨터끼리 union
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && computers[i][j] == 1) {
					union(i, j);
				}
			}
		}

		// 서로 다른 루트 개수 세기
		int answer = 0;
		boolean[] rootCheck = new boolean[n];

		for (int i = 0; i < n; i++) {
			int root = find(i);
			if (!rootCheck[root]) {
				rootCheck[root] = true;
				answer++;
			}
		}

		return answer;
	}
}