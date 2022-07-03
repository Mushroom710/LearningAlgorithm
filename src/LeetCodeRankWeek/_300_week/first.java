package LeetCodeRankWeek._300_week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @DATE 2022/7/3
 * @TIME 10:34
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static String decodeMessage(String key, String message) {
//        char[] idx = new char[26];
//        for (int i = 0;i < key.length() && i < 26;i++){
//            if (key.charAt(i) == ' ')continue;
//            if (idx[i] != ' ')continue;
//            idx[i] = key.charAt(i);
//        }
//        int j = 0;
//        while (true){
//            if (key.charAt(j) == ' ')continue;
//            if (idx[j] != ' ')continue;
//            idx[j] = key.charAt(j);
//        }
        Map<Character,Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0;i < key.length();i++){
            if (key.charAt(i) == ' ')continue;
            if (map.get(key.charAt(i)) != null)continue;
            map.put(key.charAt(i),idx);
            idx++;
        }

        char[] chs = message.toCharArray();
        for (int i = 0;i < chs.length;i++){
            if (chs[i] == ' ')continue;
            chs[i] = (char) (map.get(chs[i]) + 'a');
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key,message));
    }
}
