package LeetCodeRankWeek.shopee_team_rank;

/**
 * @DATE 2022/4/23
 * @TIME 15:42
 * @Created by zhangzhi
 * @description
 */
public class second {

    static int min = 0;

    public static void reverse(String[] matrix,int[] start, int[] end,int count){
        if (start[0] == end[0] && start[1] == end[1]){
            min = Math.min(min,count);
            return;
        }
        if (start[0] - 1 >=0){// 上
            if (matrix[start[0]].charAt(start[1]) != '^')count++;
            start[0]--;
            reverse(matrix,start,end,count);
        }
        if (start[1] + 1 < matrix[0].length()){// 右
            if (matrix[start[0]].charAt(start[1]) != '>')count++;
            start[1]++;
            reverse(matrix,start,end,count);
        }
        if (start[0] + 1 < matrix.length){// 下
            if (matrix[start[0]].charAt(start[1]) != 'v')count++;
            start[0]++;
            reverse(matrix,start,end,count);
        }
        if (start[1] - 1 >=0){// 左
            if (matrix[start[0]].charAt(start[1]) != '<')count++;
            start[1]--;
            reverse(matrix,start,end,count);
        }
    }

    public static int solution(String[] matrix, int[] start, int[] end){
        reverse(matrix,start,end,0);
        return min;
    }

    public static void main(String[] args) {
        String[] matrix = new String[]{">>v","v^<","<><"};
        int[] start = new int[]{0,1};
        int[] end = new int[]{2,0};
        System.out.println(solution(matrix,start,end));
    }
}
