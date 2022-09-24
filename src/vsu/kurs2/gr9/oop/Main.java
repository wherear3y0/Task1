package vsu.kurs2.gr9.oop;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static vsu.kurs2.gr9.oop.TrieTree.TrieNode.insert;
import static vsu.kurs2.gr9.oop.TrieTree.TrieNode.search;

public class Main {
    public static void main(String[] params) {
        String keys[] = {"Okay", "a", "hello", "world", "static", "nowhere use static", "want", "sleep"};

        String output[] = {"Есть в поиске", "Нет в поиске"};

        TrieTree.TrieNode root = new TrieTree.TrieNode();

        int i;
        for(i = 0; i < keys.length; i++){
            insert(keys[i]);
        }

        if(search("Okay") == true)
            System.out.println("Okay --- " + output[1]);
        else System.out.println("Okay --- " + output[0]);

        if(search("sleep") == true)
            System.out.println("sleep --- " + output[1]);
        else System.out.println("sleep --- " + output[0]);

        if(search("hello") == true)
            System.out.println("hello --- " + output[1]);
        else System.out.println("hello --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }
}

