package vsu.kurs2.gr9.oop;

public class TrieTree {

    static final int alfavit = 33;

    class TrieNode {

        TrieNode[] children = new TrieNode[alfavit];

        boolean end;

        TrieNode() {
            TrieNode root = new TrieNode();
            for (int i = 0; i < alfavit; i++) {
                children[i] = null;
            }

        }

    }

    private TrieNode root;


    void insert(String key) {
        int lvl;
        int index;
        int leight = key.length();


        TrieNode insrt = root;

        for (lvl = 0; lvl < leight; lvl++) {
            index = key.charAt(lvl) - 'a';
            if (insrt.children[index] == null)
                insrt = insrt.children[index] = new TrieNode();

            insrt = insrt.children[index];
        }
        insrt.end = true;
    }

    boolean search(String key) {
        int lvl;
        int index;
        int leight = key.length();

        this.root = new TrieNode();
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

