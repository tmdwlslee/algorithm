package test.programmers.level1;

import java.util.HashMap;

public class 숫자문자열과영단어 {
    static HashMap<String, Integer> map = new HashMap<>();

    static void setMap() {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }

    static String getWord(String s, int i) {
        StringBuffer word = new StringBuffer();
        int len = s.length();

        for (int j = i; j < len; j++) {
            char tc = s.charAt(j);
            if (map.containsKey(word.toString())) break;
            word.append(tc);
        }

        return word.toString();
    }

     static int solution(String s) {
        setMap();
        int answer = 0;
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }else{
                String temp = getWord(s, i);
                i += temp.length() - 1;
                sb.append(map.get(temp));
            }
        }

        answer = Integer.parseInt(sb.toString());

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("123"));
    }
}
