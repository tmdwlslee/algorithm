package test.programmers.level2;

public class 최댓값과최솟값 {
  public String solution(String s) {
    String answer = "";
    String[] numbers = s.split(" ");
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    for (String number : numbers) {
      long num = Long.parseLong(number);
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    answer = min + " " + max;

    return answer;
  }
}
