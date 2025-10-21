package week1;


public class Q04_FindMaxPlusOrMultiply {
	public static int findMaxPlusOrMultiply(int[] array) {
		int result = 0;
		for (int num : array) {
			if (num <= 1 || result <= 1) {
				result += num;
			} else {
				result *= num;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("정답 = 728 현재 풀이 값 = " + findMaxPlusOrMultiply(new int[]{0, 3, 5, 6, 1, 2, 4}));
		System.out.println("정답 = 8820 현재 풀이 값 = " + findMaxPlusOrMultiply(new int[]{3, 2, 1, 5, 9, 7, 4}));
		System.out.println("정답 = 270 현재 풀이 값 = " + findMaxPlusOrMultiply(new int[]{1, 1, 1, 3, 3, 2, 5}));
	}
}
