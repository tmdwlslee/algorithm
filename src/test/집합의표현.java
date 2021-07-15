package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {

    public static int find(int[] parents, int num){
        if(parents[num] == num){
            return num;
        }else{
            return parents[num] = find(parents, parents[num]);
        }
    }

    public static void union(int[] parents, int a, int b){
        int findA = find(parents, a);
        int findB = find(parents, b);

        if(findA == findB) return;

        parents[findB] = findA;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parents = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0){
                union(parents, a, b);
            }else{
                int findA = find(parents, a);
                int findB = find(parents, b);
                if(findA != findB){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
            }

        }

    }
}
