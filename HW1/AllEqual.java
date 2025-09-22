import java.util.Scanner;

public class AllEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a == b && a == c) {
            System.out.println("all equal");
        } else {
            System.out.println("not all equal");
        }
    }
}
