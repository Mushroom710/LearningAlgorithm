package date_one;

/**
 * @DATE 2022/2/22
 * @Created by zhangzhi
 * 二分查找题
 */
public class binarySearch {

    /**
     * @param arr 整型数组
     * @param num 待查找的数
     * @return int
     * @create zhangzhi
     * @date 2022/2/22
     * @time 21:35
    * @description 二分查找
     */
    public static int search(int[] arr,int num){
        int low = 0;
        int high = arr.length - 1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == num){
                return mid;
            }else if(arr[mid] > num){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * @param num 待查找的数
     * @return int
     * @create zhangzhi
     * @date 2022/2/22
     * @time 21:41
    * @description 找 >=num 的最左侧位置
     */
    public static int searchtwo(int[] arr,int num){


        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(search(arr,7));
    }
}
