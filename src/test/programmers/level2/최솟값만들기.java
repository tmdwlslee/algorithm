package test.programmers.level2;

import java.util.Arrays;

public class 최솟값만들기 {
  public int solution(int[] A, int[] B) {
    int answer = 0;
    Arrays.sort(A);
    Arrays.sort(B);
    int len = A.length;
    for (int i = 0; i < len; i++) {
      answer += (A[i] * B[len - i]);
    }

    return answer;
  }
}
