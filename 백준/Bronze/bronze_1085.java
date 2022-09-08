import java.util.Scanner;

public class bronze_1085 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();
    int w = sc.nextInt();
    int h = sc.nextInt();

    int xmin = Math.min(x, w - x);   // x축 최소거리
    int ymin = Math.min(y, h - y);   // y축 최소거리

    System.out.println(Math.min(xmin, ymin));
  }

}
