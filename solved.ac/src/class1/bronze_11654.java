package class1;
/**
 * Scanner : 180ms
 * System.in.read() -> 120ms
 */

import java.io.IOException;
import java.util.Scanner;

public class bronze_11654 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int ch = sc.next().charAt(0);

        int a = System.in.read();
        System.out.println(a);
    }
}
