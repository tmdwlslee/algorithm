package test.backjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {

    public static int getCnt(int[] house, int term) {
        int cnt = 1;
        int d = 0;
        int start = house[0];

        for (int i = 1; i < house.length; i++) {
            d = house[i] - start;
            if(term <= d ){
                cnt++;
                start = house[i];
            }
        }

        return cnt;
    }


    public static int binarySearch(int[] house, int c) {
        int left = 0;
        int right = 1000000000;
        int mid = 0;
        int cnt = 0;
        int ret = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            cnt = getCnt(house, mid);
            System.out.println("cnt = " + cnt + " mid = " + mid);
            if(cnt >= c){
                ret = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int answer = binarySearch(house, c);

        System.out.println(answer);
    }
}
