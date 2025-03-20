package 분할정복;

import java.io.*;

public class Q1802_종이접기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] result = new String[T];

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            result[i] = isFoldable(s) ? "YES" : "NO";
        }

        for (String res : result) {
            System.out.println(res);
        }
    }

    // 종이 접기가 가능한지 재귀적으로 확인하는 함수
    private static boolean isFoldable(String s) {
        return checkFolding(s, 0, s.length() - 1);
    }

    private static boolean checkFolding(String s, int left, int right) {
        if (left >= right) return true; // 더 이상 검사할 부분이 없으면 OK

        int mid = (left + right) / 2;

        // 중앙을 기준으로 양쪽을 검사 (거울 대칭)
        for (int i = 0; left + i < mid; i++) {
            if (s.charAt(left + i) == s.charAt(right - i)) return false;
        }

        // 왼쪽 절반과 오른쪽 절반을 각각 재귀적으로 검사
        return checkFolding(s, left, mid - 1) && checkFolding(s, mid + 1, right);
    }
}
