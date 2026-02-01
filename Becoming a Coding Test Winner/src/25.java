import java.util.Arrays;

class Solution25 {

	/**
	 * 전위, 중위, 후위 연산 모두 각 노드 한 번씩 방문 -> O(N)
	 */
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(solution(input)));
	}

	// 이 부분을 변경해서 실행해보세요.
	public static String[] solution(int[] nodes) {
		String[] result = new String[3];
		result[0] = preorder(nodes, 0).trim(); // 마지막 공백 제거
		result[1] = inorder(nodes, 0).trim();  // 마지막 공백 제거
		result[2] = postorder(nodes, 0).trim(); // 마지막 공백 제거
		return result;
	}

	private static String preorder(int[] nodes, int idx) {
		if (idx >= nodes.length) {
			return "";
		}

		return nodes[idx] + " " +
			preorder(nodes, 2 * idx + 1) +
			preorder(nodes, 2 * idx + 2);
	}

	private static String inorder(int[] nodes, int idx) {
		if (idx >= nodes.length) {
			return "";
		}

		return inorder(nodes, 2 * idx + 1) +
			nodes[idx] + " " +
			inorder(nodes, 2 * idx + 2);
	}

	private static String postorder(int[] nodes, int idx) {
		if (idx >= nodes.length) {
			return "";
		}

		return postorder(nodes, 2 * idx + 1) +
			postorder(nodes, 2 * idx + 2) +
			nodes[idx] + " ";
	}

}