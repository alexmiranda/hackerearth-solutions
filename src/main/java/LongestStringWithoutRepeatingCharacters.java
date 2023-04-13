import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.hackerearth.com/problem/algorithm/longest-string-without-repeating-characters-fa0f5ffb/
public class LongestStringWithoutRepeatingCharacters {
  public static void main(String[] args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      String input = br.readLine();
      int start = 0, max = 0;
      int cap = (int) Math.ceil(Math.min(26 * 2, input.length()) / .75f);
      var map = new HashMap<Character, Integer>(cap, .75f);

      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        int lastPos = map.getOrDefault(c, -1);
        if (lastPos >= start) {
          start = lastPos + 1;
        }
        map.put(c, i);
        int len = i - start + 1;
        if (len > max) {
          max = len;
        }
      }

      System.out.println(max);
    }
  }
}
