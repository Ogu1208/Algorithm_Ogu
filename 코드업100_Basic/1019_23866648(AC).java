import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String s;
        String[] a;
        Scanner sc = new Scanner(System.in);
        
        s = sc.nextLine();
        a=s.split("\\.");
        
        int a1 = Integer.parseInt(a[0]);
        int a2 = Integer.parseInt(a[1]);
        int a3 = Integer.parseInt(a[2]);
        
        System.out.printf("%04d.%02d.%02d", a1, a2, a3);
    }
}
