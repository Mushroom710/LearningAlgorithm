package AutumnPlan_2023.April.day_4_25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @date 2023/4/25
// @time 22:08
// @author zhangzhi
// @description LeetCode 890. 查找和替换模式
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int len = words.length;
        List<String> ans = new ArrayList<>();
        char[] pt = pattern.toCharArray();
        for(int i = 0; i < len; i++){
            char[] word = words[i].toCharArray();
            if(match(word, pt) && match(pt, word)){
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private boolean match(char[] word, char[] pattern){
        Map<Character, Character> map = new HashMap<>();
        int len = word.length;
        for(int i = 0; i < len; i++){
            if(!map.containsKey(word[i])){
                map.put(word[i], pattern[i]);
            }
            if(map.get(word[i]) != pattern[i]){
                return false;
            }
        }
        return true;
    }
}
