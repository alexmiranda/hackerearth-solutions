import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;import java.util.stream.IntStream;

// https://www.hackerearth.com/problem/algorithm/missingno-5890f366/
public class MissingNo {
  public static void main(String[] args) throws Exception {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = parseLine(br.readLine());
      int sum = IntStream.of(arr).sum();
      int sumUpToN = n * (n + 1) / 2;
      System.out.println(sumUpToN - sum);
    }
  }

  private static int[] parseLine(String str) {
    return Arrays.stream(str.split("\\D")).mapToInt(Integer::parseInt).toArray();
  }
}
