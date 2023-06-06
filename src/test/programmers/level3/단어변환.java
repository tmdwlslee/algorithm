package test.programmers.level3;

public class 단어변환 {
  private static int minCnt = Integer.MAX_VALUE;
  public static void convert(String begin, String target, String[] words, boolean[] check, int answer, int count) {
    if (begin.equals(target)) {
      minCnt = Math.min(minCnt, count);
      return;
    }
    int len = begin.length();

    for (int i = 0; i < words.length; i++) {
      int same = 0;
      if(check[i]) continue;
      for (int j = 0; j < len; j++) {
        if (words[i].charAt(j) == begin.charAt(j)) {
          ++same;
        }
      }
      if (same >= target.length() - 1) {
        check[i] = true;
        ++count;
        convert(words[i], target, words, check, answer, count);
        check[i] = false;
        --count;
      }
    }

  }

  public static int solution(String begin, String target, String[] words) {
    int answer = 0;
    boolean[] check = new boolean[words.length];
    convert(begin, target, words, check, answer, 0);
    if (minCnt == Integer.MAX_VALUE) {
      answer = 0;
    } else {
      answer = minCnt;
    }
    return answer;
  }

  public static void main(String[] args) {
    String begin = "hit";
    String target = "cog";
    String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    System.out.println(solution(begin, target, words));
  }
}
