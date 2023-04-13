import java.util.Scanner;

// https://www.hackerearth.com/problem/algorithm/good-pairing-d6da03c0/
public class GoodPairing {
  private static final int LO = 1;
  private static final int HI = 100;

  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      // read inputs
      int n = scanner.nextInt();
      scanner.nextLine(); // skip to next line

      int[] nums = new int[HI - LO + 1];
      for (int i = 0; i < n; i++) {
        int val = scanner.nextInt();
        int pos = val - LO;
        nums[pos]++;
      }

      // count pairs
      int sum = 0;
      for (int num : nums) {
        sum += (num - 1) * num / 2;
      }

      // print
      System.out.println(sum);
    }
  }
}
