package week1;

import java.util.ArrayList;
import java.util.List;

/**
 * Q. 정수를 입력 했을 때, 그 정수 이하의 소수를 모두 반환하시오.
 *
 * 소수는 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수이다.
 * # 20이 입력된다면, 아래와 같이 반환해야 합니다!
 * [2, 3, 5, 7, 11, 13, 17, 19]
 */
public class Q05_FindPrimeListUnderNumber {

	// 소수는 자기 자신과 1외 에는 아무것도 나눌 수 없다.
	public static List<Integer> findPrimeListUnderNumber(int number) {

		List<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= number; i++) {
			if (i == 2) {
				primeList.add(i);
				continue;
			}

			boolean flag = true;
			for (int j = 2; j < Math.sqrt(i); j++) {
				if (i % j == 0)  {
					flag = false;
					break;
				}
			}
			if(flag) primeList.add(i);
		}
		return primeList;
	}

	public static void main(String[] args) {
		int input = 20;
		List<Integer> result = findPrimeListUnderNumber(input);
		System.out.println(result);
	}
}
