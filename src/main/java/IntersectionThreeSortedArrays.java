import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.hackerearth.com/problem/algorithm/where-d3c6c831/
public class IntersectionThreeSortedArrays {
  public static void main(String[] args) throws Exception {
    // read inputs
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n1 = Integer.parseInt(br.readLine());
    int n2 = Integer.parseInt(br.readLine());
    int n3 = Integer.parseInt(br.readLine());
    int[] arr1 = parseLine(br.readLine());
    int[] arr2 = parseLine(br.readLine());
    int[] arr3 = parseLine(br.readLine());

    // walk the arrays and identify all common elements
    int[] common = new int[Math.min(Math.min(n1, n2), n3)];
    int p1 = 0, p2 = 0, p3 = 0, pc = 0;
    while (p1 < n1 && p2 < n2 && p3 < n3) {
      if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
        common[pc++] = arr1[p1];
        p1++;
        p2++;
        p3++;
        continue;
      }

      if (arr1[p1] <= arr2[p2] && arr1[p1] <= arr3[p3]) {
        p1++;
      } else if (arr2[p2] <= arr1[p1] && arr2[p2] < arr3[p3]) {
        p2++;
      } else if (arr3[p3] <= arr1[p1] && arr3[p3] <= arr2[p2]) {
        p3++;
      }
    }

    // print common numbers
    System.out.print(common[0]);
    for (int i = 1; i < pc; i++) {
      System.out.print(' ');
      System.out.print(common[i]);
    }
    System.out.println();
  }

  private static int[] parseLine(String str) {
    return Arrays.stream(str.split("\\D")).mapToInt(Integer::parseInt).toArray();
  }
}
