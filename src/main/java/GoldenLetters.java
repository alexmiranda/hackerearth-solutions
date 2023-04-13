import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// https://www.hackerearth.com/problem/algorithm/golden-letters-2b95250d/
public class GoldenLetters {
  public static void main(String[] args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      // read inputs
      String key = br.readLine();
      String str = br.readLine();
      HashSet<Character> golden = new HashSet<>(key.length(), 1f);
      for (int i = 0; i < key.length(); i++) {
        golden.add(key.charAt(i));
      }

      // count
      int count = 0;
      for (int i = 0; i < str.length(); i++) {
        if (golden.contains(str.charAt(i))) {
          count++;
        }
      }

      // print
      System.out.println(count);
    }
  }
}
