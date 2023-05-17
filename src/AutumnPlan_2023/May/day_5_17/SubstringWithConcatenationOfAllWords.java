package AutumnPlan_2023.May.day_5_17;

import java.util.*;
import java.util.stream.Collectors;

// @date 2023/5/17
// @time 21:39
// @author zhangzhi
// @description LeetCode 30. 串联所有单词的子串
// 双指针法。 要注意：这题的每一个字符都有可能是串联子串的起始位置，所以每个字符都要枚举一次
// 这题的 words 也没有说字符串不能重复出现
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        // 统计每个字符串出现的次数
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int slen = words[0].length();
        // 计算串联子串长度
        int total = words.length * slen;
        List<Integer> ans = new ArrayList<>();
        // 枚举每一个字符
        for(int i = 0; i <= s.length() - total; i++){
            // 标志位
            boolean flag = false;
            // 统计 words 在串联子串使用的次数
            Map<String, Integer> cnt = new HashMap<>();
            // 双指针枚举
            for(int j = i; j < i + total; j += slen){
                // 截取固定长度的子串 -- 题目已经给出：words 中每个子串长度相同
                // 所以我要截取相同长度的子串进行比较
                String sub = s.substring(j, j + slen);
                // 如果有，说明之前使用过一次
                if(cnt.containsKey(sub)){
                    int c = cnt.get(sub);
                    int t = map.get(sub);
                    // 判断剩余使用次数够不够
                    if(c < t){
                        cnt.put(sub, c + 1);
                    }else{
                        // 不够就直接退出循环
                        flag = true;
                        break;
                    }
                }else{ // 否则就说明没有使用过
                    // 判断这个子串有没有出现在 words 中
                    if(map.containsKey(sub)){
                        // 使用次数加 1
                        cnt.put(sub, 1);
                    }else{
                        // 没有直接退出循环
                        flag = true;
                        break;
                    }
                }
            }
            // 收集答案
            if(!flag){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"foo", "bar"};
        String s = "barfoothefoobarman";
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }
}
