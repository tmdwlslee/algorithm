package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 작업 {

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
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] parents = new int[n + 1];
        int[] times = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        times[1] = time;

        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());
            int maxTime = 0;
            for (int j = 0; j < cnt; j++) {
                int preJob = Integer.parseInt(st.nextToken());
                union(parents, preJob, i);
                int preTime = find(parents, i);
                //System.out.println("preTime " + preTime);
                if(parents[preJob] != preJob){
                    if(maxTime <  times[preJob])
                        maxTime = times[preJob];
                }else{
                    if(maxTime < times[preTime])
                        maxTime = times[preTime];
                }
            }
            times[i] = (time + maxTime);
        }

        int answer = 0;
        for(int i=0; i<=n; i++){
            //System.out.println("parents " + parents[i]);
            answer = Math.max(answer, times[i]);
        }
        System.out.println(answer);
    }
}
