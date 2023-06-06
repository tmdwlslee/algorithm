package test.programmers.level3;

import java.util.*;

public class 베스트앨범 {
  static class Music {
    private String genre;
    private int play;

    public Music(String genre, int play) {
      this.genre = genre;
      this.play = play;
    }
  }

  static class Rank implements Comparable<Rank>{
    private int index;
    private int play;

    public Rank(int index, int play) {
      this.index = index;
      this.play = play;
    }

    @Override
    public int compareTo(Rank o) {
      return Integer.compare(o.play, this.play);
    }
  }

  public static int[] solution(String[] genres, int[] plays) {
    int[] answer = {};
    HashMap<String, Integer> total = new HashMap<>();
    HashMap<String, Integer> count = new HashMap<>();

    for (int i = 0; i < genres.length; i++) {
      total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
      count.put(genres[i], count.getOrDefault(genres[i], 0) + 1);
    }

    List<Music> list = new LinkedList<>();
    for (Map.Entry<String, Integer> entry : total.entrySet()) {
      list.add(new Music(entry.getKey(), entry.getValue()));
    }

    int size = 0;
    for (Map.Entry<String, Integer> entry : count.entrySet()) {
      if (entry.getValue() > 1) {
        size += 2;
      }else{
        size += 1;
      }
    }
    answer = new int[size];
    int index = 0;
    Collections.sort(list, (m1, m2) -> m2.play - m1.play);
    for (int i = 0; i < list.size(); i++) {
      String gen = list.get(i).genre;
      System.out.println(gen);
      PriorityQueue<Rank> pq = new PriorityQueue<>();
      for (int j = 0; j < genres.length; j++) {
        if (genres[j].equals(gen)) {
          pq.add(new Rank(j, plays[j]));
        }
      }
      if (pq.size() > 1) {
        answer[index] = pq.poll().index;
        answer[index + 1] = pq.poll().index;
        index += 2;
      } else if (pq.size() == 1) {
        answer[index] = pq.poll().index;
        index += 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] g = {"classic", "pop", "classic", "classic", "pop"};
    int[] p = {500, 600, 150, 800, 2500};
    int[] answer = solution(g, p);
    for (int a : answer) {
      System.out.println(a);
    }
  }
}
