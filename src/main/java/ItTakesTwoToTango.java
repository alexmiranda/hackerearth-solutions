import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.hackerearth.com/problem/algorithm/it-takes-two-to-tango-a01ea264/
public class ItTakesTwoToTango {
  public static void main(String[] args) throws IOException {
    int n;
    int[] arr;
    int target;

    // read inputs
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      n = Integer.parseInt(br.readLine());
      arr = parseLine(br.readLine());
      target = Integer.parseInt(br.readLine());
    }

    // count numbers of pairs
    int[] freqs = new int[100];
    int res = 0;
    for (int i = 0; i < n; i++) {
      int delta = target - arr[i];
      if (delta > 0) {
        res += freqs[delta - 1];
      }
      freqs[arr[i] - 1]++;
    }

    // print results
    System.out.println(res);
  }

  private static int[] parseLine(String str) {
    return Arrays.stream(str.split("\\D")).mapToInt(Integer::parseInt).toArray();
  }
}
