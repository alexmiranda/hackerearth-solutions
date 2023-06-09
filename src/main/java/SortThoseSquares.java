import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

// https://www.hackerearth.com/problem/algorithm/sort-those-squares-28120a50/
public class SortThoseSquares {
  public static void main(String[] args) throws Exception {
    int n;
    int[] arr;

    // read inputs
    try (var reader = new InputStreamReader(System.in)) {
      var tokenizer = new StreamTokenizer(reader);
      tokenizer.parseNumbers();

      tokenizer.nextToken();
      n = (int) tokenizer.nval;

      arr = new int[n];
      for (int i = 0; i < n; i++) {
        tokenizer.nextToken();
        arr[i] = (int) tokenizer.nval;
      }
    }

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
          // if we reached the end of positive integers, then we fill in the remaining negative squares
          square(sorted, i + 1, arr, iNeg, -1, n);
          break;
        }
      } else {
        sorted[i] = abs * abs;
        if (--iNeg < 0) {
          // if we reached the end of negative integers, then we fill in the remaining positive squares
          square(sorted, i + 1, arr, iPos, 1, n);
          break;
        }
      }
    }

    // print results
    print(sorted, n);
  }

  private static void square(int[] dest, int startDest, int[] src, int startSrc, int step, int n) {
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
}
