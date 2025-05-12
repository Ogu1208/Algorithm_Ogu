package 정렬;

public class 선택_정렬 {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < n; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }

    }
}
