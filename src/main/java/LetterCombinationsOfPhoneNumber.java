import java.util.ArrayDeque;
import java.util.Scanner;

// https://www.hackerearth.com/problem/algorithm/letter-combinations-of-a-phone-number-2-c2eb22e5/
public class LetterCombinationsOfPhoneNumber {
  private static final char[][] digits =
      new char[][] {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
      };

  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      // read input
      long num = scanner.nextLong();
      int log10 = (int) Math.log10(num);

      // capacity is given assuming the largest possible number of letters represented by a single
      // digit combined n times
      int cap = (int) Math.pow(4, log10 + 1);
      var queue = new ArrayDeque<String>(cap);
      queue.add("");

      // read each digit of the number
      while (num > 0) {
        int pow = (int) Math.pow(10, log10);
        int n = (int) (num / pow);

        // append each possible char to the end of the existing strings and push them back into the
        // queue
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          String s = queue.pop();
          for (int j = 0; j < digits[n - 2].length; j++) {
            queue.addLast(s + digits[n - 2][j]);
          }
        }
        num %= pow;
        log10--;
      }

      // print results
      while (!queue.isEmpty()) {
        System.out.println(queue.pop());
      }
    }
  }
}
