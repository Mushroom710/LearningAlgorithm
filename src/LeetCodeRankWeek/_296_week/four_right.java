package LeetCodeRankWeek._296_week;

/**
 * @DATE 2022/6/5
 * @TIME 12:28
 * @Created by zhangzhi
 * @description
 */

class TextEditor_ {

    StringBuffer sb;
    int cursor;

    public TextEditor_() {
        sb = new StringBuffer();
        cursor = 0;
    }

    public void addText(String text) {
        sb.insert(cursor,text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        if (cursor <= k){
            int old = cursor;
            sb.replace(0,cursor,"");
            cursor = 0;
            return old;
        }else {
            sb.replace(cursor - k,cursor,"");
            cursor -= k;
            return k;
        }
    }

    public String cursorLeft(int k) {
        if (cursor >= k){
            cursor -= k;
            return cursor >= 10 ? sb.substring(cursor - 10,cursor) : sb.substring(0,cursor);
        }else {
            cursor = 0;
            return "";
        }
    }


    public String cursorRight(int k) {
        int len = sb.length();
        if (cursor + k <= len) {
            // 1.右边够移动
            cursor += k;
            // 返回光标左边 min(10, len)
            return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
        } else {
            // 2.右边不够移动
            cursor = len;
            return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
        }
    }
}

public class four_right {

    public static void main(String[] args) {
        TextEditor_ textEditor = new TextEditor_();
        textEditor.addText("LeetCode");
        System.out.println(textEditor.deleteText(4));
        System.out.println(textEditor);
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorLeft(2));
        System.out.println(textEditor.cursorRight(6));
        System.out.println(textEditor);
    }
}
