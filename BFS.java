import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    
    static Scanner ip = new Scanner(System.in);
    public static void main(String[] args) {
        
        int n, u;
        System.out.print("Nhap so dinh: ");
        n = ip.nextInt();
        System.out.print("Nhap diem bat dau: ");
        u = ip.nextInt();
        int[][] a = new int[100][100];
        input(n, a);
        output(n, a);
        bfs(n, u, a);
    }

    public static void bfs(int n,int u, int[][] a) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.add(u);
        visited[u] = true;

        while (!q.isEmpty()) {
            int v = q.peek(); //Trả về phần từ đầu hàng đợi
            q.poll(); //Loại bỏ phần tử đầu hàng đợi
            System.out.print(v + " -> "); //Thăm 

            for (int j = 0; j < n; j++) {
                if (a[v][j] == 1) {
                    if (!visited[j]) {
                        q.add(j);
                        visited[j] = true;
                    }
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