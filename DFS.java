import java.util.Scanner;


public class DFS {
    static int n, u;
    static int[][] a = new int[100][100];
    static boolean[] visited = new boolean[10];
    static Scanner ip = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.print("Nhap so dinh: ");
        n = ip.nextInt();
        System.out.print("Nhap diem bat dau: ");
        u = ip.nextInt();
        
        input(n, a);
        output(n, a);
        dfs(u);
    }

    public static void dfs(int u) {
        System.out.print((u + 1) + " -> ");
        visited[u] = true;

        //Duyet cac dinh ke voi u
        for (int j = 0; j < n; j++) { 
            if (a[u][j] == 1) {
                if (!visited[j]) {
                    dfs(j);
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
