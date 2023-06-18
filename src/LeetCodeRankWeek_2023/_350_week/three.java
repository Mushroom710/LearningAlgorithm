package LeetCodeRankWeek_2023._350_week;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/18
// @time 10:45
// @author zhangzhi
// @description
public class three {

    private long ans = 0;

    private long mod = (long) (Math.pow(10, 9) + 7);

    private boolean[] flag;

    private List<Integer> list;

    private void dfs(int[] nums){
        if(list.size() == nums.length){
            ans = (ans + 1) % mod;
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!flag[i]){
                flag[i] = true;
                list.add(nums[i]);
                int size = list.size();
                if((list.get(size - 1) % list.get(size - 2) == 0) || (list.get(size - 2) % list.get(size - 1) == 0)){
                    dfs(nums);
                }
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }

    public int specialPerm(int[] nums) {
        this.flag = new boolean[nums.length];
        this.list = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            flag[i] = true;
            list.add(nums[i]);
            dfs(nums);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384};
        System.out.println(new three().specialPerm(nums));
    }
}
