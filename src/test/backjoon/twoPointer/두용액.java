package test.backjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] liquid = new long[n];

        for (int i = 0; i < n; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liquid);

        int start = 0;
        int end = n - 1;
        long min = Long.MAX_VALUE;
        long[] ans = new long[2];
        ans[0] = liquid[start];
        ans[1] = liquid[end];
        while(start < end){
            long sum = liquid[start] + liquid[end];

            if(sum == 0){
                ans[0] = liquid[start];
                ans[1] = liquid[end];
                break;
            }

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans[0] = liquid[start];
                ans[1] = liquid[end];
            }

            if(sum > 0){
                end--;
            }else {
                start++;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
