package vsu.kurs2.gr9.oop;

public class Main {


    public static void main(String[] params) {
        String[] keys = {"Okay", "a", "hello", "world", "static", "nowhere use static", "want", "sleep"};

        String[] output = {"Есть в поиске", "Нет в поиске"};

        TrieTree tree = new TrieTree();

        int i;
        for(i = 0; i < keys.length; i++){
            tree.insert(keys[i]);
        }

        if(tree.search("Okay")) {
            System.out.println("Okay --- " + output[1]);
        } else {System.out.println("Okay --- " + output[0]);}

        if(tree.search("sleep")) {
            System.out.println("sleep --- " + output[1]);
        } else {System.out.println("sleep --- " + output[0]);}

        if(tree.search("hello")) {
            System.out.println("hello --- " + output[1]);
        } else {System.out.println("hello --- " + output[0]);}

        if(tree.search("thaw")) {
            System.out.println("thaw --- " + output[1]);
        } else { System.out.println("thaw --- " + output[0]);}
    }
}

