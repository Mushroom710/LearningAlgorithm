package LeetCodeRankWeek._305_week;

// @DATE 2022/8/7
// @TIME 10:54
// @AUTHOR zhangzhi
// @DESCRIPTION

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class second {

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> re = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> set_restricted = new HashSet<>();
        for (int num : restricted){
            set_restricted.add(num);
        }

        for(int[] nums : edges){
            Arrays.sort(nums);
        }

        Arrays.sort(edges, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        re.add(0);
        set.add(0);
        for(int i = 0;i < edges.length;i++){
            if (!set_restricted.contains(edges[i][0])){
                if (!set_restricted.contains(edges[i][1])){
                    set.add(edges[i][1]);
                }
                set.add(edges[i][0]);
            }
        }
        System.out.println(set.toString());
        return set.size();
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{8,2},{2,5},{5,0},{2,7},{1,7},{3,8},{0,4},{3,9},{1,6}};
        int[] restricted = new int[]{9,8,4,5,3,1};
        System.out.println(reachableNodes(10,edges,restricted));
    }
}
