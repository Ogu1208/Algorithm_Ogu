package 정렬;

public class 삽입_정렬 {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < n; i++) {
            // 인덱스 i부터 1까지 감소하며 반복
            for (int j = i; j > 0; j++) {
                // 한 칸씩 왼쪽으로 이동
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

                // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
                else break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
