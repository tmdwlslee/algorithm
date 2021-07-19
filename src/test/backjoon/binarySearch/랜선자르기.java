package test.backjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기 {

    public static long getLen(long[] lan, long cm){
        long total = 0;
        for (int i = 0; i < lan.length; i++) {
            total += (lan[i]/cm);
        }
        return total;
    }

    public static long binarySearch(long[] lan, int n) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        long mid = 0;
        long len = 0;
        long max = 0;
        while (left <= right){
            mid = (left + right)/2;
            len = getLen(lan, mid);

            if(len >= n){
                left = mid + 1;
                max = Math.max(max, mid);
            }else{
                right = mid - 1;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lan = new long[k];


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            lan[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(binarySearch(lan, n));
    }
}
