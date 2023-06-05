package test.programmers.level3;

public class 정수삼각형 {
  public int solution(int[][] triangle) {
    int answer = 0;
    int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];
    dp[0][0] = triangle[0][0];
    for (int i = 1; i < triangle.length; i++) {
      for (int j = 0; j < triangle[i].length; j++) {
        if (j == 0) {
          dp[i][j] = Math.max(dp[i - 1][0] + triangle[i][0], dp[i][j]);
        } else if (j == triangle[i].length - 1) {
          dp[i][j] = Math.max(dp[i - 1][triangle[i].length - 2] + triangle[i][triangle[i].length - 2], dp[i][j]);
        }else{
          dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
        }
      }
    }
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }

    return answer;
  }

  public static void main(String[] args) {

  }
}
