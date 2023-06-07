package test.programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 순위 {
  public static int solution(int n, int[][] results) {
    int answer = 0;
    int[][] graph = new int[n + 1][n + 1];
    int INF = 987654321;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if(i!=j){
          graph[i][j] = INF;
        }
      }
    }

    for (int i = 0; i < results.length; i++) {
      int winner = results[i][0];
      int loser = results[i][1];
      graph[winner][loser] = 1;
    }
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      int cnt = 0;
      for (int j = 1; j <= n; j++) {
        if (i!=j && (graph[i][j] != INF || graph[j][i] != INF)) {
          ++cnt;
        }
      }
      if (cnt == n - 1) {
        ++answer;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(
    solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
  }
}
