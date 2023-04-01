package AutumnPlan_2023.March.day_3_3;

// @date 2023/3/3
// @time 21:08
// @author zhangzhi
// @description

public class HIndex2 {

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n - 1;
        int h = 0;
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            if(citations[mid] == n - mid){
                l = mid + 1;
                h = Math.max(h, citations[mid]);
            }else if(citations[mid] > n - mid){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return h;
    }

    /**
     * 设查找范围的初始左边界left 为 0, 初始右边界right 为 n−1，其中
     * n 为数组 citations 的长度。每次在查找范围内取中点 mid，则有
     * n−mid 篇论文被引用了至少 citations[mid] 次。如果在查找过程中满足
     * citations[mid]≥n−mid，则移动右边界 right，否则移动左边界 left
     * @param citations
     * @return
     */
    public static int solution(int[] citations){
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if(citations[mid] >= n - mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return n - left;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{0,1,3,5,6};
        System.out.println(hIndex(citations));
    }
}
