package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 작업_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        dp[1] = time;
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());
            int maxTime = 0;
            for (int j = 0; j < cnt; j++) {
                int preJob = Integer.parseInt(st.nextToken());
                maxTime = Math.max(dp[preJob], maxTime);
            }
            dp[i] = maxTime + time;
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println(dp[i]);
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
