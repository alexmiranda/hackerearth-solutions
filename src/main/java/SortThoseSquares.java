import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.hackerearth.com/problem/algorithm/sort-those-squares-28120a50/
public class SortThoseSquares {
  public static void main(String[] args) throws Exception {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = parseLine(br.readLine());
      assert arr.length == n;
      String answer =
          IntStream.of(arr)
              .map(i -> i * i)
              .sorted()
              .mapToObj(Integer::toString)
              .collect(Collectors.joining(" "));
      System.out.println(answer);
    }
  }

  private static int[] parseLine(String str) {
    return Arrays.stream(str.split("\\s+")).mapToInt(Integer::parseInt).toArray();
  }
}
