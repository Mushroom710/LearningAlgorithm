package Trie;

/**
 * @DATE 2022/3/12
 * @TIME 9:57
 * @Created by zhangzhi
 * @description LeetCode 208 题 实现字典树(Trie)也称 前缀树
 */

// 字典树结点类
class TrieNode{
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];//全是小写英文字母
    public TrieNode(){}
    public TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
         root = new TrieNode();
         root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null){
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}


public class implementTrie {

    public static void main(String[] args) {

    }
}
