package AutumnPlan_2023.June.day_6_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// @date 2023/6/1
// @time 11:37
// @author zhangzhi
// @description LeetCode 306. 累加数

/**
 * <p>
 * 数字会超过Long的范围，所以采用BigInteger。
 * 这里有一些剪枝优化，前两个数长度任意，第三个数开始，一定比前一个数大，对应下来就是长度更长。
 * 思路：与131题类似。
 * 这题只需要找到一个解就行，所以找到的时候，就可以直接返回答案。
 * <p/>
 * <p>
 * 高精度加法的实现思路可以看做是计算机加法器的原理。
 * 在计算机加法器中，也是将两个数的每一位对应相加，并且处理进位。
 * 这种思路简单而直接，也比较容易理解和实现。
 * <p/>
 * <p>
 * 对于 BigInteger 类型的实现，其底层确实也是采用了类似的思路，
 * 即将大整数分为若干个 int 类型的数组来存储，并且对应位上进行加法运算，并处理进位。
 * BigInteger 类也提供了 add 方法来进行加法运算，内部实现就是基于此原理。
 * <p/>
 * <p>
 * 另外，由于计算机硬件的限制，实际上计算机中的加法器通常只能处理固定长度的数据（如 32 位或 64 位）。
 * 因此，在进行高精度计算时，需要将大整数分为多个 int 或 long 类型的数字来进行计算，
 * 这样才能保证计算结果正确并且没有溢出。
 * <p/>
 */
public class AdditiveNumber {
    List<String> path;
    String s;
    private boolean isAdd(int start, int end){
        String sub = s.substring(start, end + 1);
        BigInteger n = new BigInteger(sub);
        int size = path.size();
        return new BigInteger(path.get(size - 2)).add(new BigInteger(path.get(size - 1))).compareTo(n) == 0;
    }
    private boolean dfs(int i){
        if(i == s.length()){
            //System.out.println(path);
            int size = path.size();
            return size > 2 && new BigInteger(path.get(size - 3)).add(new BigInteger(path.get(size - 2))).compareTo(new BigInteger(path.get(size - 1))) == 0;
        }
        for(int j = i; j < s.length(); j++){
            if(j > i && s.charAt(i) == '0'){
                return false;
            }
            String sub = s.substring(i, j + 1);
            if(path.size() >= 2){
                //System.out.println(path.get(path.size() - 1) + "-" + sub);
                if(path.get(path.size() - 1).length() > sub.length()){
                    continue;
                }
            }
            if(path.size() < 2){
                path.add(sub);
                if(dfs(j + 1)){
                    return true;
                }
                path.remove(path.size() - 1);
            }else{
                if(isAdd(i, j)){
                    path.add(sub);
                    if(dfs(j + 1)){
                        return true;
                    }
                    path.remove(path.size() - 1);
                }
            }
        }
        return false;
    }
    public boolean isAdditiveNumber(String num) {
        this.path = new ArrayList<>();
        this.s = num;
        return dfs(0);
    }
}
