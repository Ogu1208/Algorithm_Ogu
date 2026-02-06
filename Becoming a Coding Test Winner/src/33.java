import java.util.Arrays;

class Solution33 {

	static int[] parent;

	public int solution(int n, int[][] costs) {
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		Arrays.sort(costs, (a, b) -> a[2] - b[2]); // cost 기준으로 정렬

		int totalCost = 0;
		int edgeCount = 0;

		for (int[] edge : costs) {
			int a = edge[0];
			int b = edge[1];
			int cost = edge[2];

			if (find(a) != find(b)) {
				union(a, b); // 서로 통하게 만듦
				totalCost += cost;
				edgeCount++;

				if (edgeCount == n - 1)
					break;
			}
		}

		return totalCost;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return find(parent[x]);
	}

	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		parent[rootY] = rootX;
	}
}