package vsu.kurs2.gr9.oop;

import java.util.Scanner;

public class Main {
    public static void main(String[] params) {
        String[] keys = {"okay", "a", "hello", "world", "static", "nowhereusestatic", "want", "sleep"};

        String[] output = {"Есть в поиске", "Нет в поиске"};

        TrieTree tree = new TrieTree();
        TrieTree.TrieNode node = new TrieTree.TrieNode();

        int i;
        for (i = 0; i < keys.length; i++) {
            tree.insert(keys[i]);
        }
        Scanner scanner = new Scanner(System.in);
        String name;
        int what;
        int q;

        System.out.println("Выберите что вы хотите сделать\n1.Вставить элемент\n2.Удалить элемент\n3.Поиск");
        q = (scanner.nextInt());
        if(q == 1 ){
            String word;
            System.out.println("Напишите слово которое вы хотите вставить \n Учтите что оно должно быть на английском" +
                    " языке и без пробелов");
            word = (scanner.next());
            tree.insert(word);
        } else if(q == 2){
            String word;
            System.out.println("Напишите какой элемент вы хотите удалить\nУчтите что оно должно быть на английском"
            +" языке и без пробелов");
            word = (scanner.next());
            tree.remove(node, word, 0);
        } else if(q == 3){
            System.out.println("Введите ваше слово для поиска");
            System.out.println("Прошу вводить без пробела, на английском языке");
            name = (scanner.next());
            if (tree.search(name)) {
                System.out.println(name + " --- " + output[0]);
            } else {
                System.out.println(name + " --- " + output[1]);
            }
        }


       /* if (tree.search("sleep")) {
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
        }*/
    }
}