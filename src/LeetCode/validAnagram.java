package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @DATE 2022/2/28
 * @Created by zhangzhi
 * @description LeetCode242题
 * 结合哈希表学习
 * 1.直接对字符串进行排序，比较排序后的字符串是否相等即可
 * 2.对每一个字符进行计数，统计字符出现次数。最后比较出现次数是否相等即可
 */
public class validAnagram {

    //直接对字符串排序
    public static boolean solution(String s,String t){
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return Arrays.equals(sarr,tarr);
    }

    //用HashMap统计字符出现次数
    public static boolean solutionTwo(String s,String t){
        if(s.length() != t.length())return false;//字符串长度都不一致，直接返回false
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();

        for(int i = 0;i<s.length();i++){
            if(smap.containsKey(s.charAt(i))){
                smap.put(s.charAt(i),smap.get(s.charAt(i))+1);
            }else{
                smap.put(s.charAt(i),1);
            }
            if(tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i),tmap.get(t.charAt(i))+1);
            }else{
                tmap.put(t.charAt(i),1);
            }
        }
        return smap.equals(tmap);
    }

    public static void main(String[] args) {
        String s = "cat";
        String t = "taaaaa";
        System.out.println(solution(s,t));
        System.out.println(solutionTwo(s,t));
    }

}
