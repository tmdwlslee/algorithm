package test.programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {

  class Node {
    int index;
    int dist;

    public Node(int index, int dist) {
      this.index = index;
      this.dist = dist;
    }
  }

  public int solution(int n, int[][] edge) {
    List<List<Integer>> distance = new ArrayList<>(n + 1);
    for (int i = 0; i < n; i++) {
      distance.add(new ArrayList<>());
    }

    for (int i = 0; i < edge.length; i++) {
      int nodeA = edge[i][0];
      int nodeB = edge[i][1];
      distance.get(nodeA).add(nodeB);
      distance.get(nodeB).add(nodeA);
    }
    Queue<Node> q = new LinkedList<>();
    boolean[] visited = new boolean[n + 1];
    q.offer(new Node(1, 0));
    visited[1] = true;
    Node ans = new Node(0, 0);

    while (!q.isEmpty()) {
      Node start = q.poll();
      for (int next : distance.get(start.index)) {
        if (!visited[next]) {
          visited[next] = true;
          if (ans.index == start.dist + 1) {
            ans.dist += 1;
          } else if (ans.index < start.dist + 1) {
            ans.index = start.dist + 1;
            ans.dist = 1;
          }
          q.offer(new Node(next, start.dist + 1));
        }
      }
    }

    return ans.dist;
  }
}
