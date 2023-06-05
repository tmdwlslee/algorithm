package test.programmers.level3;

import java.util.*;

public class 이중우선순위큐 {

  public static int[] solution(String[] operations) {
    int[] answer = new int[2];
    int actionFlag = 0;
    int insertFlag = 0;
    PriorityQueue<Integer> minQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
    for (String operation : operations) {
      String[] op = operation.split(" ");
      String command = op[0];
      String data = op[1];
      if (command.equals("I")) {
        int number = Integer.parseInt(data);
        insertFlag += 1;
        minQ.add(number);
        maxQ.add(number);
      } else{
        actionFlag += 1;
        if (insertFlag == actionFlag) {
          minQ.clear();
          maxQ.clear();
        }
        int action = Integer.parseInt(data);
        if (action == 1) {
          maxQ.poll();
        } else{
          minQ.poll();
        }
      }
    }
    System.out.println(insertFlag + " " + actionFlag);
    if (maxQ.size() > 0 && (insertFlag - actionFlag) > 1) {
      answer[0] = maxQ.poll();
    }
    if (minQ.size() > 0 && (insertFlag - actionFlag) > 1) {
      answer[1] = minQ.poll();
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] answer = solution(new String[]{"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"});
    System.out.println(answer[0] + " " + answer[1]);
  }
}
