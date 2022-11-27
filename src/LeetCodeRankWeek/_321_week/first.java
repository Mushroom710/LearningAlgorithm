package LeetCodeRankWeek._321_week;

// @date 2022/11/27
// @time 10:22
// @author zhangzhi
// @description

public class first {

    public static int pivotInteger(int n) {
        int mid = n / 2;
        int left = mid * (mid + 1) / 2;
        int right = n * (n + 1) / 2 - left + mid;
        while(true){
            if(left == right){
                return mid;
            }else if(left < right){
                mid++;
                left += mid;
                right -= mid - 1;
                if(left > right){
                    return -1;
                }
            }else {
                mid--;
                left -= mid;
                right += mid - 1;
                if(right > left){
                    return -1;
                }
            }
            if(mid <= 0 || mid > n){
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }

}
