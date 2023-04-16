import java.util.Scanner;

// https://www.hackerearth.com/problem/algorithm/rotate-matrix-f91b5f98/
public class RotateMatrix {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      // read inputs
      int n = scanner.nextInt();
      int[][] arr = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          arr[i][j] = scanner.nextInt();
        }

        if (scanner.hasNextLine()) {
          scanner.nextLine();
        }
      }

      // rotate and print
      for (int i = 0; i < n; i++) {
        System.out.print(arr[n - 1][i]);
        for (int j = n - 2; j >= 0; j--) {
          System.out.print(' ');
          System.out.print(arr[j][i]);
        }
        System.out.println();
      }
    }
  }
}
