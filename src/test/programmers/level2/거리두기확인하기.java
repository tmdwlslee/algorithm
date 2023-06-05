package test.programmers.level2;

public class 거리두기확인하기 {

    static class test implements Comparable<test>{

        @Override
        public int compareTo(test o) {
            return 0;
        }
    }

    public static void solution() {

        String str = "abcde";

        char c = 'a';

        System.out.println((char)(c+25));

        System.out.println('i' - 'a');

        System.out.println((char)('a' + 7));

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 1; i++) {
            int start = 1;
            int end = 3;

            sb.append(str.substring(start - 1, end));

            System.out.println(sb.toString());
        }

        str = sb.toString();

        System.out.println(str);

    }
    public static void main(String[] args) {
        solution();
    }
}
