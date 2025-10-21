package week1;

public class Q01_FindMaxNum {
	public static int findMaxNum(int[] array) {
		int maxNum = array[0];

		for (int num : array) {
			if (maxNum < num) {
				maxNum = num;
			}
		}
		return maxNum;
	}

	public static void main(String[] args) {
		System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{3, 5, 6, 1, 2, 4}));
		System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 6, 6}));
		System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 9, 2, 7, 1888}));
	}
}
