package week1;

public class Q002_IsNumberExists {

	// 빅오 -> 최악의 경우.
	// 빅오메가 -> 최선의 경우
	public static boolean isNumberExist(int number, int[] array) {
		for (int num : array) {
			if (num == number)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("정답 = true 현재 풀이 값 = " + isNumberExist(3, new int[]{3, 5, 6, 1, 2, 4})); // 운이 좋은 경우!! 시간복잡도가 1밖에 안 걸림.
		// -> 최선의 경우에는 1만큼의 연산만 필요하다.

		System.out.println("정답 = true 현재 풀이 값 = " + isNumberExist(4, new int[]{3, 5, 6, 1, 2, 4})); // 운이 좋지 않은 경우!!
		// 이 경우에는 배열의 끝까지 찾아야 하기 때문에, 시간복잡도가 N 만큼 걸린다.

		System.out.println("정답 = false 현재 풀이 값 = " + isNumberExist(7, new int[]{6, 6, 6}));
		System.out.println("정답 = true 현재 풀이 값 = " + isNumberExist(2, new int[]{6, 9, 2, 7, 1888}));
	}
}
