package AutumnPlan_2023.May.day_5_8;

import java.util.HashMap;
import java.util.Map;

// @date 2023/5/8
// @time 22:07
// @author zhangzhi
// @description
public class AlphabetBoardPath {
    public static String alphabetBoardPath(String target) {
        Map<Character, int[]> pos = new HashMap<>();
        char[][] board = new char[6][5];
        char ch = 'a';
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                pos.put(ch, new int[]{i, j});
                board[i][j] = ch;
                ch = (char)(ch + 1);
            }
        }
        pos.put(ch, new int[]{5, 0});
        board[5][0] = ch;
        StringBuilder sb = new StringBuilder();
        char[] chs = target.toCharArray();
        int[] preIdx = new int[]{0, 0};
        for(int k = 0; k < target.length(); k++){
            int[] nextIdx = pos.get(chs[k]);
            if(chs[k] == board[preIdx[0]][preIdx[1]]){
                sb.append("!");
                continue;
            }
            if(board[preIdx[0]][preIdx[1]] == 'z'){
                preIdx = new int[]{4, 0};
                sb.append("U");
            }
            boolean flag = false;
            if(chs[k] == 'z'){
                nextIdx = new int[]{4, 0};
                flag = true;
            }
            int row = nextIdx[0] - preIdx[0];
            int col = nextIdx[1] - preIdx[1];
            if(row < 0){
                for(int i = 0; i < Math.abs(row); i++){
                    sb.append("U");
                }
            }else{
                for(int i = 0; i < row; i++){
                    sb.append("D");
                }
            }
            if(col < 0){
                for(int i = 0; i < Math.abs(col); i++){
                    sb.append("L");
                }
            }else{
                for(int i = 0; i < col; i++){
                    sb.append("R");
                }
            }
            if(flag){
                sb.append("D");
            }
            sb.append("!");
            preIdx = nextIdx;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String target = "zdz";
        System.out.println(alphabetBoardPath(target));
    }
}
