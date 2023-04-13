import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StuffThemCandiesIn {
  public static void main(String[] args) throws Exception {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] candies = parseLine(br.readLine());
      assert candies.length == n;
      int extraCandies = Integer.parseInt(br.readLine());
      int max = IntStream.of(candies).max().getAsInt();
      String answer =
          IntStream.of(candies)
              .map(x -> x + extraCandies >= max ? 1 : 0)
              .mapToObj(Integer::toString)
              .collect(Collectors.joining(" "));
      System.out.println(answer);
    }
  }

  private static int[] parseLine(String str) {
    return Arrays.stream(str.split("\\D")).mapToInt(Integer::parseInt).toArray();
  }
}
