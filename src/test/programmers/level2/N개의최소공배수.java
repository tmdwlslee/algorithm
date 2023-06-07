package test.programmers.level2;

import java.util.Arrays;

public class N개의최소공배수 {
  public int getGCD(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  public int getLCD(int a, int b) {
    return (a * b) / getGCD(a, b);
  }

  public int solution(int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    int a = arr[1];
    int b = arr[0];
    int lcd = getLCD(a, b);

    for (int i = 2; i < arr.length; i++) {
      if (arr[i] > lcd) {
        lcd = getLCD(arr[i], lcd);
      } else{
        lcd = getLCD(lcd, arr[i]);
      }
    }
    answer = lcd;
    return answer;
  }
}
