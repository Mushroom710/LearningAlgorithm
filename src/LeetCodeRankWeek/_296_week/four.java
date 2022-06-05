package LeetCodeRankWeek._296_week;

/**
 * @DATE 2022/6/5
 * @TIME 11:08
 * @Created by zhangzhi
 * @description
 */

class TextEditor {

    StringBuffer sb;
    int cur_position;

    public TextEditor() {
        this.sb = new StringBuffer();
        this.cur_position = 0;
    }

    public void addText(String text) {
        if (this.cur_position == 0){
            if (this.sb.length() != 0){
                this.sb.deleteCharAt(0);
            }
            this.sb.append(text).append("|");
            this.cur_position = text.length();
            return;
        }
        this.sb.insert(this.cur_position,text);
        this.cur_position += text.length();
    }

    public int deleteText(int k) {
        if (k >= this.cur_position){
            int temp = this.cur_position;
            this.cur_position = 0;
            this.sb.delete(0,temp);
            return temp;
        }
        int start = this.cur_position - k;
        this.sb.deleteCharAt(this.cur_position);
        this.sb.delete(start,start + k + 1);
        this.sb.insert(start,"|");
        this.cur_position -= k;
        return k;
    }

    public String cursorLeft(int k) {
        if (this.cur_position == 0){
            return "";
        }else if (this.cur_position - k - 1 < 0){
            this.sb.deleteCharAt(this.cur_position);
            this.sb.insert(0,"|");
            this.cur_position = 0;
            int offset = 0;
            int start = 0;
            return this.sb.substring(start, 0);
        }
        this.sb.deleteCharAt(this.cur_position);
        this.sb.insert(this.cur_position - k,"|");
        this.cur_position -= k;
        int offset = Math.min(10,this.cur_position);
        int start = this.cur_position - offset;
        return this.sb.substring(start,start + offset);
    }

    public String cursorRight(int k) {
        if (this.cur_position + k > this.sb.length() - 1){
            this.sb.deleteCharAt(this.cur_position);
            this.cur_position = this.sb.length();
            this.sb.insert(this.cur_position,"|");
//            this.cur_position = 0;
//            int offset = Math.min(10,this.cur_position);
//            int start = this.cur_position - offset;
//            return this.sb.substring(start,start + offset);
            return "";
        }
        this.sb.deleteCharAt(this.cur_position);
        this.sb.insert(this.cur_position + k,"|");
        this.cur_position = k;
        int offset = Math.min(10,this.cur_position);
        int start = this.cur_position - offset;
        return this.sb.substring(start,start + offset);
    }
    public String toString(){
        return this.sb.toString();
    }
}

public class four {

    public static void main(String[] args) {
//        TextEditor textEditor = new TextEditor();
//        textEditor.addText("LeetCode");
//        System.out.println(textEditor.deleteText(4));
//        System.out.println(textEditor);
//        textEditor.addText("practice");
//        System.out.println(textEditor.cursorRight(3));
//        System.out.println(textEditor.cursorLeft(8));
//        System.out.println(textEditor.deleteText(10));
//        System.out.println(textEditor.cursorLeft(2));
//        System.out.println(textEditor.cursorRight(6));
//        System.out.println(textEditor);

        //        [[],["cyberworks"],[21],[2],[6],["aaaaa"],[1]]
        TextEditor textEditor = new TextEditor();
        textEditor.addText("jxarid");
        System.out.println(textEditor.cursorLeft(5));
        System.out.println(textEditor.cursorLeft(10));
        textEditor.addText("du");
        System.out.println(textEditor.deleteText(20));
    }
}
