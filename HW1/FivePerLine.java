public class FivePerLine {
    public static void main(String[] args) {

        for (int i = 1000; i < 2000; i += 5) {
            for (int j = 0; j < 5; j++) {
                System.out.print((i + j) + " ");
            }
            System.out.println("");
        }
        System.out.print("2000");
    }
}
