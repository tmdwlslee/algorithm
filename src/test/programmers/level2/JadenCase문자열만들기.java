package test.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class JadenCase문자열만들기 {
  public static String solution(String s) {
    StringBuffer answer = new StringBuffer();
    String[] words = s.split("\\s+");
    String[] blanks = s.split("[a-z,A-Z,0-9]");
    Queue<String> q = new LinkedList<>();

    for (String blank : blanks) {
      if (!blank.equals("")) {
        q.add(blank);
        System.out.println("blank " + blank);
      }
    }


    for (int i=0; i<words.length; i++) {
      String word = words[i];
      System.out.println(word);
      if (!word.equals("")) {
        String head = String.valueOf(word.charAt(0));
        answer.append(head.toUpperCase()).append(word.substring(1).toLowerCase());
      }
      if (!q.isEmpty()) {
        answer.append(q.poll());
      }
    }

    return answer.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution("    3people unFollowed me"));
  }
}
