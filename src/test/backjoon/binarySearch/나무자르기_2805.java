package test.backjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기_2805 {

    public static long getTree(long[] trees, long height){
        long total = 0;
        for (int i = 0; i < trees.length; i++) {
            if(trees[i] > height){
                total += (trees[i] - height);
            }
        }
        return total;
    }

    public static long binarySearch(long[] trees, long m){
        long left = 0;
        long right = 2000000000;
        long mid = 0;
        long tree = 0;
        long maxHeight = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            tree = getTree(trees, mid);
            System.out.println("mid = " + mid);
            if(tree < m){
                right = mid - 1;
            }else{
                left = mid + 1;
                maxHeight = Math.max(maxHeight, mid);
            }
        }

        return maxHeight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] trees = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(trees, m));
    }
}
