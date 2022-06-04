package SummerPlan_2022.day_6_4;

/**
 * @DATE 2022/6/4
 * @TIME 20:03
 * @Created by zhangzhi
 * @description LeetCode 45 题 跳跃游戏 II
 */
public class JumpGameII {

    /**
     * @create zhangzhi
     * @date 2022/6/4
     * @time 20:12
     * @description
     * 真正解题的时候，要从覆盖范围出发，不管怎么跳，覆盖范围内一定是可以跳到的，
     * 以最小的步数增加覆盖范围，覆盖范围一旦覆盖了终点，得到的就是最小步数！
     * 这里需要统计两个覆盖范围，当前这一步的最大覆盖和下一步最大覆盖。
     */
    public static int jump(int[] nums) {
        if (nums.length == 1)return 0;
        int curDistance = 0;// 当前覆盖最远距离下标
        int nextDistance = 0;// 下一步覆盖最远距离下标
        int ans = 0;// 记录走的最大步数
        for (int i = 0;i < nums.length;i++){
            nextDistance = Math.max(i + nums[i],nextDistance);// 更新下一步覆盖最远距离下标
            // 这里还是有个特殊情况需要考虑，当移动下标达到了当前覆盖的最远距离下标时
            //  如果当前覆盖最远距离下标不是是集合终点，步数就加一，还需要继续走。
            //  如果当前覆盖最远距离下标就是是集合终点，步数不用加一，因为不能再往后走了。
            if (i == curDistance){// 遇到当前覆盖最远距离下标
                if (curDistance != nums.length - 1){// 如果当前覆盖最远距离下标不是终点
                    ans++;// 需要走下一步
                    curDistance = nextDistance;// 更新当前覆盖最远距离下标（相当于加油了）
                    if (nextDistance >= nums.length)break;// 下一步的覆盖范围已经可以达到终点，结束循环
                }else break;// 当前覆盖最远距离下标是集合终点，不用做ans++操作了，直接结束
            }
        }
        return ans;
    }

    /**
     * @create zhangzhi
     * @date 2022/6/4
     * @time 20:14
     * @description
     * 针对于方法一的特殊情况，可以统一处理，
     * 即：移动下标只要遇到当前覆盖最远距离的下标，直接步数加一，不考虑是不是终点的情况。
     * 想要达到这样的效果，只要让移动下标，最大只能移动到 nums.size - 2的地方就可以了。
     * 因为当移动下标指向 nums.size - 2 时：
     *  如果移动下标等于当前覆盖最大距离下标， 需要再走一步（即 ans++），
     *  因为最后一步一定是可以到的终点。（题目假设总是可以到达数组的最后一个位置）
     *  如果移动下标不等于当前覆盖最大距离下标，说明当前覆盖最远距离就可以直接达到终点了，不需要再走一步
     */
    public static int jump_two(int[] nums){
        if (nums.length == 1)return 0;
        int curDistance = 0;// 当前覆盖的最远距离下标
        int nextDistance = 0;// 下一步覆盖的最远距离下标
        int ans = 0;// 记录走的最大步数
        for (int i = 0;i < nums.length - 1;i++){// 注意这里是小于nums.size() - 1，这是关键所在
            nextDistance = Math.max(i + nums[i],nextDistance);// 更新下一步覆盖的最远距离下标
            if (i == curDistance){// 遇到当前覆盖的最远距离下标
                ans++;
                curDistance = nextDistance;// 更新当前覆盖的最远距离下标
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(jump(nums));
        System.out.println(jump_two(nums));
    }
}
