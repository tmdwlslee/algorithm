package test.backjoon.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 {

    public static int upperBound(int[] nums, int num, int n) {
        int left = 0;
        int right = n;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if(nums[mid] <= num){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    public static int lowerBound(int[] nums, int num, int n) {
        int left = 0;
        int right = n;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if(nums[mid] >= num){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();


        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int lowIdx = lowerBound(nums, num, n);
            int highIdx = upperBound(nums, num, n);

            bw.write((highIdx - lowIdx) + " ");
        }
        bw.flush();
    }
}
