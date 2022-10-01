import java.util.Arrays;

public class memo {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {2, 3}};
        int[][] b = {{3, 4}, {5, 6}};
        System.out.println("answer = " + Arrays.toString(solution(a, b)));

    }
}
