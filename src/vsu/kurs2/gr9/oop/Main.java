package vsu.kurs2.gr9.oop;

public class Main {
    public static void main(String[] params) {
        String[] keys = {"okay", "a", "hello", "world", "static", "nowhereusestatic", "want", "sleep"};

        String[] output = {"Есть в поиске", "Нет в поиске"};

        TrieTree tree = new TrieTree();

        int i;
        for (i = 0; i < keys.length; i++) {
            tree.insert(keys[i]);
        }

        if (tree.search("okay")) {
            System.out.println("okay --- " + output[0]);
        } else {
            System.out.println("okay --- " + output[1]);
        }

        if (tree.search("sleep")) {
            System.out.println("sleep --- " + output[0]);
        } else {
            System.out.println("sleep --- " + output[1]);
        }

        if (tree.search("hello")) {
            System.out.println("hello --- " + output[0]);
        } else {
            System.out.println("hello --- " + output[1]);
        }

        if (tree.search("thaw")) {
            System.out.println("thaw --- " + output[0]);
        } else {
            System.out.println("thaw --- " + output[1]);
        }
    }
}