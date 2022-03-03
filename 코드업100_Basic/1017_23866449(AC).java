import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        
        for(int i = 0; i < 3; i ++){
            System.out.printf("%d ", x);
        }
    }
}
