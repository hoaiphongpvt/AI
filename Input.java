import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        int[][] a = new int[100][100];
        Scanner ip = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n = ip.nextInt();
        input(n, a);
        output(n, a);
        ip.close(); // Close Scanner0
    }

    public static void input(int n, int[][] a) {

        System.out.println("Nhap ma tran: ");
        Scanner ip = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
                a[i][j] = ip.nextInt();
            }
            System.out.println();
        }
        ip.close(); // Close Scanner
    }

    public static void output(int n, int[][] a) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
