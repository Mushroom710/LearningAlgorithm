package LeetCodeRankWeek._290_week;

import java.nio.channels.Pipe;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @DATE 2022/4/24
 * @TIME 11:06
 * @Created by zhangzhi
 * @description
 */

class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class second {

    static int count = 0;
    public static void iteration(int x0,int y0,int r, Map<Integer, Point> result){
        Set<Integer> set = new HashSet<>();
        for (int x = x0-r;x <= x0 + r;x++){
            for (int y = y0 - r;y <= y0+r;y++){
                if (((x-x0)*(x-x0) + (y-y0)*(y-y0)) <= r * r){
                    Point point = new Point(x,y);
                    if (!set.add(x * y)){
                        Point p = result.get(x * y);
                        if (p.x == x && p.y == y){
                            break;
                        }
                    }
                    count++;
                    result.put(x * y,point);
                }
            }
        }
    }

    public static int solution(int[][] circles){
        Map<Integer,Point> ans = new HashMap<>();
        for (int[] circle : circles){
            iteration(circle[0],circle[1],circle[2],ans);
        }
        return ans.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2,2,2},{3,4,1}}));
        System.out.println(count);
    }
}
