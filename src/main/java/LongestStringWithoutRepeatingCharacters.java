import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

// https://www.hackerearth.com/problem/algorithm/longest-string-without-repeating-characters-fa0f5ffb/
public class LongestStringWithoutRepeatingCharacters {
  public static void main(String[] args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      String input = br.readLine();
      var queue = new PriorityQueue<String>((a, b) -> b.length() - a.length());
      queue.add(input);

      // bfs for the longest string without repeating chars
      while (!queue.isEmpty()) {
        String curr = queue.poll();
        if (!hasDup(curr)) {
          System.out.println(curr.length());
          return;
        }

        if (curr.length() > 1) {
          queue.add(curr.substring(1));
          queue.add(curr.substring(0, curr.length() - 1));
        }
      }

      // if we couldn't find any non-repeating characters in the whole string, then we return 1
      System.out.println(1);
    }
  }

  private static boolean hasDup(String str) {
    var seen = new HashSet<Character>(str.length(), 1f);
    for (int i = 0; i < str.length(); i++) {
      if (!seen.add(str.charAt(i))) {
        return true;
      }
    }
    return false;
  }
}
