package test.programmers.level2;

public class 올바른괄호 {
  boolean solution(String s) {
    boolean answer = true;
    int len = s.length();
    int cnt = 0;
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '(') {
        ++cnt;
      }else{
        --cnt;
      }
      if(cnt < 0) {
        answer = false;
        break;
      }
    }
    if (cnt > 0) {
      answer = false;
    }

    return answer;
  }
}
