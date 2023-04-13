import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.hackerearth.com/problem/algorithm/generate-parentheses-3-f138b035/
public class GenerateParentheses {
  public static void main(String[] args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      var list = new ArrayList<String>(catalan(n));
      generateParentheses(list, "", 0, 0, n);
      while (!list.isEmpty()) {
        System.out.println(list.remove(0));
      }
    }
  }

  private static void generateParentheses(
      List<String> list, String prev, int opened, int closed, int n) {
    // we are done, just shove the prev value into the resulting list
    if (opened == n && closed == n) {
      list.add(prev);
      return;
    }

    // open if we can
    if (opened < n) {
      generateParentheses(list, prev + "(", opened + 1, closed, n);
    }

    // close if we can
    if (closed < opened) {
      generateParentheses(list, prev + ")", opened, closed + 1, n);
    }
  }

  private static int catalan(int n) {
    if (n <= 1) return 1;
    int fac2n = fac(n * 2);
    int facn = fac(n);
    return fac2n / facn / facn / (n + 1);
  }

  private static int fac(int n) {
    int res = 1;
    for (int i = 1; i <= n; i++) {
      res *= i;
    }
    return res;
  }
}
