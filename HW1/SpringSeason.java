import java.util.Scanner;

public class SpringSeason {
    public static boolean Check(int m, int d) {
        if (m < 3 || m > 6) return false;
        if (m == 3) {
            if (d >= 20 && d <= 31) return true;
            return false;
        }
        if (m == 4) {
            if (d >= 1 && d <= 30) return true;
            return false;
        }
        if (m == 5) {
            if (d >= 1 && d <= 31) return true;
            return false;
        }
        // m = 6
        if (d >= 1 && d <= 20) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();

        System.out.print(Check(m, d));
    }
}
