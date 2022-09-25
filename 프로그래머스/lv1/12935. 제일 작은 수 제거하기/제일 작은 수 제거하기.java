class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int [arr.length - 1];
        int min = arr[0];
        int idx = 0;
        
        if(arr.length == 1) {
            answer = new int[] {-1};
            return answer;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i]) {
                continue;
            }
            answer[idx++] = arr[i];
        }


        return answer;
    }
}