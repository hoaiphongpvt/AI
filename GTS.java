import java.util.ArrayList;
import java.util.Scanner;

public class GTS {

    static Scanner ip = new Scanner(System.in);
    public static void main(String[] args) {
        
        int n, u;
        int[][] a = new int[100][100];
        System.out.print("Nhap so dinh: ");
        n = ip.nextInt();
        System.out.print("Nhap diem xuat phat: ");
        u = ip.nextInt();
        input(n, a);
        output(n, a);
        gts(n, u, a);
    }

    public static void gts(int n, int u, int[][] a) {

        ArrayList<Integer> tour = new ArrayList<Integer>();
        int colMin = 0;
        int cost = 0;
        int row = u;
        int count = 0;
        tour.add(row);
        
        while (count < n - 1) {

            int min = 100;
            int part = 0;
            for (int j = 0; j < n; j++) {
                if (!tour.contains(j) && a[row][j] != 0 && a[row][j] < min) {
                    min = a[row][j];
                    colMin = j;
                    part = a[row][j];
                }
            }
            row = colMin;
            cost += part;
            tour.add(colMin);
            count++;
            
        }

        //Quay lai dinh dau
        tour.add(u);
        cost += a[row][u];
        
        System.out.print("Thu tu cac dinh la: ");
        for (int item : tour) {
            System.out.print(item + " ");
        }
        System.out.println("\nTong hao phi la: " + cost);
    }

    public static void input(int n, int[][] a) {

        System.out.println("Nhap ma tran: ");
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
                a[i][j] = ip.nextInt();
            }
            System.out.println();
        }
    }

    public static void output(int n, int[][] a) {
        
        System.out.println("Ma tran vua nhap la: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
