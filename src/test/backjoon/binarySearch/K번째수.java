package test.backjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수 {

    public static long binarySearch(long n, long k){
        long left = 1;
        long right = n*n; // long으로 받을 거면 n도 long으로 할 것
        long mid = 0;
        long cnt = 0;
        long ret = Long.MAX_VALUE;
        while (left <= right) {
            mid = (left + right) / 2;
            cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n); // 찾은 숫자(mid)에 row를 나누면 해당 숫자보다 작은 숫자의 개수가 된다.
            }

            if (cnt < k) {
                left = mid + 1;
            }else{
                ret = mid;
                right = mid - 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        System.out.println(binarySearch(n,k));
    }
}
