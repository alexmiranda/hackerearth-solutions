import java.util.Scanner;

// https://www.hackerearth.com/problem/algorithm/verify-the-alien-dictionary-68f2836e/
public class VerifyTheAlienDictionary {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var key = scanner.nextLine().chars().toArray();
      assert key.length == 26;

      int[] order = new int[26];
      for (int i = 0; i < 26; i++) {
        order[key[i] - 'A'] = i;
      }

      int n = scanner.nextInt();
      scanner.nextLine(); // skip to next line

      String prev = scanner.nextLine();
      for (int i = 1; i < n; i++) {
        String curr = scanner.nextLine();
        int cmp = cmp(prev, curr, order);
        if (cmp > 0) {
          System.out.println(0);
          return;
        }
        prev = curr;
      }

      System.out.println(1);
    }
  }

  private static int cmp(String a, String b, int[] order) {
    int res = 0;
    if (a.equals(b)) {
      return res;
    }

    int smallest = Math.min(a.length(), b.length());
    for (int i = 0; i < smallest; i++) {
      res = order[a.charAt(i) - 'A'] - order[b.charAt(i) - 'A'];
      if (res == 0) {
        continue;
      }
      return res;
    }

    return a.length() > b.length() ? 1 : -1;
  }
}
