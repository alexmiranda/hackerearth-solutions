import java.util.Scanner;

// https://www.hackerearth.com/problem/algorithm/remove-all-adjacent-duplicates-from-a-string-a9676bd7/
public class DestroyThosePairs {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      scanner.useDelimiter("");
      char[] chars = new char[10_000];

      // read inputs
      int n = 1;
      chars[0] = scanner.next().charAt(0);
      while (scanner.hasNext()) {
        chars[n] = scanner.next().charAt(0);
        // dedup
        if (n > 0 && chars[n] == chars[n - 1]) {
          n--;
          continue;
        }
        n++;
      }

      // print
      for (int i = 0; i < n; i++) {
        System.out.print(chars[i]);
      }
      System.out.println();
    }
  }
}
