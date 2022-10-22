import java.util.Scanner;
import java.util.ArrayList;

public class GTS2 {
    
    static Scanner ip = new Scanner(System.in);
    public static void main(String[] args) {
        
        int n, p;
        int[][] a = new int[100][100];
        System.out.print("Nhap so dinh: ");
        n = ip.nextInt();
        System.out.print("Nhap so duong di: ");
        p = ip.nextInt();
        input(n, a);
        output(n, a);
        gts2(n, p, a);
    }

    public static void gts2(int n, int p, int[][] a) {
        int bestCost = 1000;
        ArrayList<Integer> bestTour = new ArrayList<Integer>();
        for (int i = 0; i < p; i++) {
            Object[] GTS1 = gts(n, i, a);
            if ((int) GTS1[1] < bestCost) {
                bestCost = (int) GTS1[1];
                bestTour = (ArrayList<Integer>) GTS1[0];
            }
        }
        System.out.println("Chu trinh co duong di ngan nhat la: " + bestTour + " voi chi phi la: " + bestCost);
    }


    public static Object[] gts(int n, int u, int[][] a) {

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
                if (a[row][j] < min && !tour.contains(j) && a[row][j] != 0) {
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

        tour.add(u);
        cost += a[row][u];
        
        System.out.print("Thu tu cac dinh la: ");
        for (int item : tour) {
            System.out.print(item + " ");
        }
        System.out.println("\nTong hao phi la: " + cost);

        return new Object[] {tour, cost};
    }

    public static void input(int n, int[][] a) {

        System.out.println("Nhap ma tran: ");
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
                a[i][j] = ip.nextInt();
            }
            System.out.println();
        }
        ip.close(); // Close Scanner
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
