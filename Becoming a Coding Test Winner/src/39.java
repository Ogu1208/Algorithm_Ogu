import java.util.ArrayDeque;

class Solution39 {

	private static int N, M;
	private static int[] dirR = {0, 0, 1, -1};
	private static int[] dirC = {1, -1, 0, 0};
	private static char[][] map;

	public static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public int solution(String[] maps) {
		int answer = 0;
		N = maps.length;
		M = maps[0].length();

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = maps[i].toCharArray();
		}

		Node start = null, end = null, lever = null;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'S') {
					start = new Node(i, j);
				} else if (map[i][j] == 'E') {
					end = new Node(i, j);
				} else if (map[i][j] == 'L') {
					lever = new Node(i, j);
				}
			}
		}

		int startToLever = bfs(start, lever);
		int levelToEnd = bfs(lever, end);

		if (startToLever == -1 || levelToEnd == -1) {
			return -1;
		} else {
			return startToLever + levelToEnd;
		}
	}

	private static int bfs(Node start, Node end) {
		int[][] dist = new int[N][M];
		dist[start.r][start.c] = 1;
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.addLast(start);

		while (!queue.isEmpty()) {
			Node now = queue.pollFirst();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dirR[i];
				int nc = now.c + dirC[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				if (map[nr][nc] == 'X') {
					continue;
				}

				if (dist[nr][nc] == 0) {
					queue.addLast(new Node(nr, nc));
					dist[nr][nc] = dist[now.r][now.c] + 1;
				}

				if (nr == end.r && nc == end.c) {
					return dist[nr][nc] - 1;
				}
			}
		}

		return -1;
	}
}