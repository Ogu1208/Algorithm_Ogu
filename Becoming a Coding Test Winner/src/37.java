import java.util.ArrayDeque;

class Solution37 {

	private static final int[] dirX = {0, 0, 1, -1};
	private static final int[] dirY = {1, -1, 0, 0};

	public static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public int solution(int[][] maps) {
		int N = maps.length;
		int M = maps[0].length;

		// 최단 거리 저장
		int[][] dist = new int[N][M];

		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.addLast(new Node(0, 0));
		dist[0][0] = 1;

		while (!queue.isEmpty()) {
			Node now = queue.pollFirst();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dirX[i];
				int nc = now.c + dirY[i];

				// 맵 밖으로 나가는 경우
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}

				// 벽인 경우
				if (maps[nr][nc] == 0) {
					continue;
				}

				// 이동한 위치가 처음 방문하느 경우, queue에 추가하고 거리 갱신
				if (dist[nr][nc] == 0) {
					queue.addLast(new Node(nr, nc));
					dist[nr][nc] = dist[now.r][now.c] + 1;
				}
			}
		}

		return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
	}
}