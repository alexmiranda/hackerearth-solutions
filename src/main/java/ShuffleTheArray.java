import java.util.Scanner;

// https://www.hackerearth.com/problem/algorithm/shuffle-the-array/
public class ShuffleTheArray {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      // read the inputs
      int n = scanner.nextInt();
      int len = n * 2;
      int[] arr = new int[len];

      // shuffle
      for (int i = 0; i < len; i++) {
        arr[i / n + (i % n) * 2] = scanner.nextInt();
      }

      // print
      System.out.print(arr[0]);
      for (int i = 1; i < len; i++) {
        System.out.print(' ');
        System.out.print(arr[i]);
      }
      System.out.println();
    }
  }
}
