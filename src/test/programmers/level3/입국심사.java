package test.programmers.level3;


import java.util.Arrays;

public class 입국심사 {
  public static long solution(int n, int[] times) {
    Arrays.sort(times);
    long minTime = 1;
    long maxTime = times[times.length - 1] * (long)n;
    long answer = maxTime;

    while (minTime <= maxTime) {
      long midTime = (minTime + maxTime) / 2;
      System.out.println(midTime);
      long count = 0;
      for (int i = 0; i < times.length; i++) {
        count += midTime / times[i];
        if (count >= n) {
          break;
        }
      }
      if (count >= n) {
        maxTime = midTime - 1;
        answer = Math.min(answer, midTime);
      }else {
        minTime = midTime + 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    solution(6, new int[]{7, 10});
  }
}
