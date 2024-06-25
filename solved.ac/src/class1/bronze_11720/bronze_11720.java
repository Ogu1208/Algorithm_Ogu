package class1.bronze_11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader + str.readLine().getBytes()
 * 시간 : 128ms
 */

public class bronze_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();  // N 입력받기

        int sum = 0;

        for (byte value : br.readLine().getBytes()) {  // 문자열을 byte[]로 반환
            sum += (value - '0');
        }

        System.out.println(sum);
    }
}
