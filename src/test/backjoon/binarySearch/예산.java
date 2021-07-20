package test.backjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산 {

    public static int getCal(int[] money, int mid){
        int cal = 0;
        for (int i = 0; i < money.length; i++) {
            if(money[i] >= mid){
                cal += mid;
            }else{
                cal += money[i];
            }
        }

        return cal;
    }

    public static int binarySearch(int[] money, int total, int max){
        int left = 0;
        int right = max;
        int mid = 0;
        int cal = 0;
        int ret = 0;
        while(left <= right){
            mid = (left + right) / 2;
            cal = getCal(money, mid);
            System.out.println("cal = " + cal + " mid = " +mid);
            if(total >= cal){
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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] money = new int[n];
        int total = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            max = Math.max(money[i], max);
        }

       int answer =  binarySearch(money, total, max);
        System.out.println(answer);
    }
}
