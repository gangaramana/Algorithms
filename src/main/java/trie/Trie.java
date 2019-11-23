package trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    public Map<Character, TrieNode> getMap() {
        return map;
    }

    public void setMap(Map<Character, TrieNode> map) {
        this.map = map;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    private Map<Character, TrieNode> map;
    private boolean isEnd;

    TrieNode() {
        map = new HashMap<>();
        isEnd = false;
    }
}

public class Trie {
    TrieNode root = new TrieNode();

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ramana");
        trie.insert("ramya");
        trie.insert("rishi");
        System.out.println(trie.search("rishi"));
    }

    private void insert(String k) {
        TrieNode tmp = root;
        char[] c = k.toCharArray();
        for (int i = 0; i < k.length(); i++) {
            if (tmp.getMap().containsKey(c[i])) {
                tmp = tmp.getMap().get(c[i]);
            } else {
                TrieNode n = new TrieNode();
                tmp.getMap().put(c[i], n);
                tmp = n;
            }
        }
        tmp.setEnd(true);
    }


    private boolean search(String k) {
        TrieNode tmp = root;
        char[] c = k.toCharArray();
        for (int i = 0; i < k.length(); i++) {
            if (tmp.getMap().containsKey(c[i])) {
                tmp = tmp.getMap().get(c[i]);
            } else {
                return false;
            }
        }
        if (tmp.isEnd()) {
            return true;
        }
        return false;
    }
}
