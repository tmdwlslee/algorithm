package test.programmers.level3;

public class 네트워크 {
  private void connect(int node, boolean[] visited, int[][] computers) {
    if (visited[node]) {
      return;
    }
    visited[node] = true;
    for (int i = 0; i < computers[node].length; i++) {
      if (node != i && computers[node][i] == 1) {
        connect(i, visited, computers);
      }
    }
  }

  public int solution(int n, int[][] computers) {
    int answer = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        answer += 1;
        connect(i, visited, computers);
      }
    }

    return answer;
  }
}
