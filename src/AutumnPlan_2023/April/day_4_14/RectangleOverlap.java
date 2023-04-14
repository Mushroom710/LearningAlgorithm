package AutumnPlan_2023.April.day_4_14;

// @date 2023/4/14
// @time 16:36
// @author zhangzhi
// @description LeetCode 836. 矩形重叠

public class RectangleOverlap {

    /**
     * 降维打击，把二维问题转换为一维问题。转换为一维，就成了考虑区间是否重叠，如果区间重叠，这说明二维矩形重叠。
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean x = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
        boolean y = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
        return x && y;
    }
}
