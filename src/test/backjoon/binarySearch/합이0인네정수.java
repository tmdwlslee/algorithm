package test.backjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0인네정수 {

    public static int upperBound(long[] sum, long num){
        int left = 0;
        int right = sum.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (sum[mid] <= num) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static int lowerBound(long[] sum, long num){
        int left = 0;
        int right = sum.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (sum[mid] >= num) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];
        long[] sumX = new long[n * n];
        long[] sumY = new long[n * n];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumX[n * i + j] = A[i] + B[j];
                sumY[n * i + j] = C[i] + D[j];
            }
        }

        Arrays.sort(sumY);

        int ans = 0;

        for (int i = 0; i < n * n; i++) {
            int high = upperBound(sumY, -sumX[i]);
            int low = lowerBound(sumY, -sumX[i]);
            ans += (high - low);
        }


        System.out.println(ans);
    }
}
