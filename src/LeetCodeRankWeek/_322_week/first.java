package LeetCodeRankWeek._322_week;

// @date 2022/12/4
// @time 10:25
// @author zhangzhi
// @description

public class first {

    public static boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");
        int splitLen = split.length;
        if(splitLen == 1){
            return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
        }
        for(int i = 1;i < splitLen; i++){
            if(split[i - 1].charAt(split[i - 1].length() - 1) != split[i].charAt(0)){
                return false;
            }
        }
        return split[0].charAt(0) == split[splitLen - 1].charAt(split[splitLen - 1].length() - 1);
    }

    public static void main(String[] args) {
        String sentence = "Leetcode is cool";
        System.out.println(isCircularSentence(sentence));
    }
}
