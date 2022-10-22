import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AStar {

    static Scanner ip = new Scanner(System.in);
    static ArrayList<Integer> Open = new ArrayList<>();
    static ArrayList<Integer> Close = new ArrayList<>();

    public static void main(String[] args) {
        int n;
        int[][] a = new int[100][100];
        int[] estimatedCost = new int[100];
        System.out.print("Nhap so dinh: ");
        n = ip.nextInt();
        input(n, a);
        inputEstimatedCost(n, estimatedCost);
        output(n, a);
    }

    public static void Astar(int a[][], int n, int start, int finish, int cost) {
        Open.add(start);
        while (!Open.isEmpty()) {
            int q = findMin(Open);
            Open.remove(findMin(Open));
            if (q == finish) break;
            
            
        }
    }

    public static int findMin(ArrayList<Integer> Open) {
       return Open.indexOf(Collections.min(Open));
    }

    public static void input(int n, int[][] a) {
        System.out.println("Nhap ma tran trong so: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = ip.nextInt();
            }
        }
    }

    public static void inputEstimatedCost(int n, int[] estimatedCost) {
        System.out.print("Nhap chi phi uong luong: ");
        for (int i = 0; i < n; i++) {
            estimatedCost[i] = ip.nextInt();
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
