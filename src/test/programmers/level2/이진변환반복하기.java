package test.programmers.level2;

public class 이진변환반복하기 {
  public static int[] solution(String s) {
    int[] answer = new int[2];

    convertBinary(answer, s, 1);

    return answer;
  }

  private static void convertBinary(int[] answer, String s, int count) {
    if (s.equals("1")) {
      answer[0] = count;
      return;
    }
    ++count;
    int newNum = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        answer[1]++;
      }else {
        newNum++;
      }
    }

    StringBuffer sb = new StringBuffer();
    while (newNum > 0) {
      sb.append(newNum % 2);
      newNum /= 2;
    }
    convertBinary(answer, sb.toString(), count);
  }

  public static void main(String[] args) {
    solution("110010101001");
  }
}
