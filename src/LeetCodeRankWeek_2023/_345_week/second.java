package LeetCodeRankWeek_2023._345_week;

import java.util.ArrayList;
import java.util.List;

// @date 2023/5/14
// @time 10:25
// @author zhangzhi
// @description 想的太多反而把题目想复杂了。其实第一位只能填 0 或 1，填了之后，后面的数就被确定了下来。
// 对于最后一个数，它是和第 0 位数进行异或的，所以 original 可以初始化为 len + 1
// 这样在填完数之后，只需要比较 original[0] == original[len - 1] 就可以知道是不是合法的。
// 喵的，开始的时候被这个环给误导了，想的太复杂了。
public class second {

    private int[] original;

    private int[] derived;

    private final int[] num = new int[]{0 , 1};

    private int len;

    public boolean doesValidArrayExist(int[] derived) {
        this.len = derived.length;
        if(len == 1){
            return derived[0] != 1;
        }
        this.derived = derived;
        this.original = new int[len];
        return dfs(len - 1);
    }

    private boolean dfs(int i) {
        if(i == 0){
            return (original[0] ^ original[1]) == derived[0] && (original[0] ^ original[len - 1]) == derived[len - 1];
        }
        original[i] = 1;
        if(i < len - 1){
            if((original[i] ^ original[i + 1]) == derived[i]){
                if(dfs(i - 1)){
                    return true;
                }
            }
        }else {
            if(dfs(i - 1)){
                return true;
            }
        }
        original[i] = 0;
        if(i < len - 1){
            if((original[i] ^ original[i + 1]) == derived[i]){
                if (dfs(i - 1)){
                    return true;
                }
            }
        }
        return dfs(i - 1);
    }

    public boolean doesValidArrayExist2(int[] derived) {
        int len = derived.length;
        int[] original = new int[len + 1];
        for(int i = 0; i < len; i++){
            if(derived[i] == 1){
                original[i + 1] = original[i] == 0 ? 1 : 0;
            }else{
                original[i + 1] = original[i] == 0 ? 0 :1;
            }
        }
        if(original[0] == original[len]){
            return true;
        }
        original[0] = 1;
        for(int i = 0; i < len; i++){
            if(derived[i] == 1){
                original[i + 1] = original[i] == 0 ? 1 : 0;
            }else{
                original[i + 1] = original[i] == 0 ? 0 :1;
            }
        }
        return original[0] == original[len];
    }

    public static void main(String[] args) {
        int[] de = new int[]{0,0,1};
        System.out.println(new second().doesValidArrayExist2(de));
    }
}
