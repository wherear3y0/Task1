package vsu.kurs2.gr9.oop;

public class TrieTree {
    private TrieNode root = new TrieNode();

    static final int alfavit = 33;

    static class TrieNode {

        TrieNode[] children = new TrieNode[alfavit];

        boolean end;

        TrieNode() {
            for (int i = 0; i < alfavit; i++) {
                children[i] = null;
            }
        }

    }



    void insert(String key) {
        int lvl;
        int index;
        int leight = key.length();


        TrieNode insrt = root;

        for (lvl = 0; lvl < leight; lvl++) {
            index = key.charAt(lvl) - 'a';
            if (insrt.children[index] == null)
                insrt.children[index] = new TrieNode();

            insrt = insrt.children[index];
        }
        insrt.end = true;
    }

    boolean search(String key) {
        int lvl;
        int index;
        int leight = key.length();

        TrieNode insrt = root;

        for (lvl = 0; lvl < leight; lvl++) {
            index = key.charAt(lvl) - 'a';
            if (insrt.children[index] == null)
                return false;

            insrt = insrt.children[index];
        }
        return (insrt.end);
    }


}
