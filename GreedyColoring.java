import java.util.ArrayList;
import java.util.Scanner;

public class GreedyColoring {

    static Scanner ip = new Scanner(System.in);
    public static void main(String[] args) {

        int n;
        System.out.print("Nhap so dinh: ");
        n = ip.nextInt();
        int[][] a = new int[100][100];
        input(n, a);
        coloring(n, a);
    }

    public static void coloring(int n, int[][] a) {

        int[] verticesDesc = sortVertices(n, a);
        int[] arrayColor = new int[n];
        int countColor = 1;
        ArrayList<Integer> visited = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
           if (!visited.contains(verticesDesc[i])) {
                visited.add(verticesDesc[i]);
                arrayColor[verticesDesc[i]] = countColor;
                for (int j = 0; j < n; j++) {
                    if (a[verticesDesc[i]][j] == 0 && !visited.contains(j)) {
                        visited.add(j);
                        arrayColor[j] = countColor;
                    }
                }
                countColor++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Dinh " + (i + 1) + " co mau " + arrayColor[i] + " ");
        }
    }

    public static int[] sortVertices(int n, int[][] a) {

        int[] tenDinh = new int[n];
        int[] bac = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    count++;
                }
            }
            bac[i] = count;
            tenDinh[i] = i;
        }
        
        sortDESC(bac, tenDinh);
        return tenDinh;
    }

    public static void sortDESC(int[] bac, int[] tenDinh) {

        int temp = bac[0];
        int tempDinh = tenDinh[0];
        for (int i = 0 ; i < bac.length - 1; i++) {
            for (int j = i + 1; j < bac.length; j++) {
                if (bac[i] < bac[j]) {

                    temp = bac[j];
                    bac[j] = bac[i];
                    bac[i] = temp;
                    
                    tempDinh = tenDinh[j];
                    tenDinh[j] = tenDinh[i];
                    tenDinh[i] = tempDinh;
                }
            }
        }
    }

    public static void input(int n, int[][] a) {

        System.out.println("Nhap ma tran: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = ip.nextInt();
            }
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
