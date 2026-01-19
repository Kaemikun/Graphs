import java.util.ArrayList;
import java.util.Scanner;

public class List {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(n + 1);

        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
            
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            matrix.get(u).add(v);
            matrix.get(v).add(u); // For undirected graph
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
