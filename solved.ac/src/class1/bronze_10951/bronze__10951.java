package class1.bronze_10951;

import java.util.Scanner;

/**
 * 시간 : 228 ms
 */

public class bronze__10951 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
        sc.close();
    }
}
