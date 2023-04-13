import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.hackerearth.com/problem/algorithm/sort-those-squares-28120a50/
public class SortThoseSquares {
  public static void main(String[] args) throws Exception {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      // read inputs
      int n = Integer.parseInt(br.readLine());
      int[] arr = parseLine(br.readLine());

      // determine start of positive and negative indexes
      int[] sorted = new int[n];
      int iPos = Arrays.binarySearch(arr, 0);
      if (iPos < 0) {
        iPos = Math.abs(iPos) - 1;
      }
      int iNeg = iPos - 1;
      if (iNeg < 0) {
        // if there are no negative numbers, we should just square all the numbers and print
        square(sorted, 0, arr, 0, 1, n);
        print(sorted, n);
        return;
      }

      // iterate through all numbers using both pos and neg indexes
      for (int i = 0; i < n; i++) {
        int abs = Math.abs(arr[iNeg]);
        if (arr[iPos] < abs) {
          sorted[i] = arr[iPos] * arr[iPos];
          if (++iPos == n) {
            square(sorted, i + 1, arr, iNeg, -1, n);
            break;
          }
        } else {
          sorted[i] = abs * abs;
          if (--iNeg < 0) {
            square(sorted, i + 1, arr, iPos, 1, n);
            break;
          }
        }
      }

      // print results
      print(sorted, n);
    }
  }

  private static void square(int dest[], int startDest, int[] src, int startSrc, int step, int n) {
    for (; startDest < n; startDest++) {
      dest[startDest] = src[startSrc] * src[startSrc];
      startSrc += step;
    }
  }

  private static void print(int[] sorted, int n) {
    System.out.print(sorted[0]);
    for (int i = 1; i < n; i++) {
      System.out.print(' ');
      System.out.print(sorted[i]);
    }
    System.out.println();
  }

  private static int[] parseLine(String str) {
    return Arrays.stream(str.split("\\s+")).mapToInt(Integer::parseInt).toArray();
  }
}
