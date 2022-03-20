package LeetCodeRankWeek._285_week;

/**
 * @DATE 2022/3/20
 * @TIME 11:31
 * @Created by zhangzhi
 */
public class second {

    public static int solution(String directions){
        int count = 0;
        char[] arr = directions.toCharArray();
        for(int idx = 0; idx < arr.length - 1; ){
            if(arr[idx] != arr[idx+1]){
                if(arr[idx]=='R' && arr[idx+1]=='L'){
                    count +=2;
                    arr[idx+1] = 'S';
                }
//                else if(arr[idx]=='L' && arr[idx+1]=='R'){
//                    count +=2;
//                    arr[idx+1] = 'S';
//                }
            else if(arr[idx] == 'S' && arr[idx+1] == 'L'){
                    count++;
                    arr[idx+1] = 'S';
                }else if(arr[idx] == 'S' && arr[idx+1] == 'R'){
                    count++;
                    arr[idx+1] = 'S';
                }else if(arr[idx] == 'L' && arr[idx+1] == 'S'){
                    count++;
                }else if(arr[idx] == 'R' && arr[idx+1] == 'S'){
                    count++;
                }
                idx++;
            }else {
                idx++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "LLRR";
        System.out.println(solution(s));
    }
}
