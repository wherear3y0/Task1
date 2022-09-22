package vsu.kurs2.gr9.oop;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] params) throws IOException {// тут считываем данные из файла
        List<String> lines = Files.readAllLines(Paths.get("/Users/wherear3y0/Desktop/Папка/ВУЗДЗ/2 курс/ООП/Task1/src/vsu/kurs2/gr9/oop/numbers.txt"));

        TreeNode root = new TreeNode(' '); // берем пробел
        for(String line: lines){
            root.insert(line);
        }

        //System.out.println(root.containString("а401мр97"));


        writeTree("/Users/wherear3y0/Desktop/Папка/ВУЗДЗ/2 курс/ООП/Task1/src/vsu/kurs2/gr9/oop/result.txt", root);

        TreeNode fromFile = readFromFile("/Users/wherear3y0/Desktop/Папка/ВУЗДЗ/2 курс/ООП/Task1/src/vsu/kurs2/gr9/oop/result.txt");

        List<String> extractedFromThree = new ArrayList<>(); // вывод данных
        root.getAllNumbers("", extractedFromThree);
    }


    static class TreeNode{
        char value;
        List<TreeNode> children;

        public TreeNode(char value){
            this.value = value;
        }

        public void insert(String data) {
            if (data.length() == 0){ // проверка на пустую строку
                return;
            }
            if (children == null){
                children = new ArrayList<>();
            }
            char c = data.charAt(0);
            TreeNode child = findNodeByChar(c); // есть ли такой узел??
            if (child == null) { // создадим сами если нулл
                child = new TreeNode(c);
                children.add(child);
            }
            child.insert(data.substring(1)); // сабстринг чтобы получить строку без 1 символа
        }

        private TreeNode findNodeByChar(char c) { // для проверки символов есть ли список таких узлов
            if (children != null) {
                for (TreeNode node : children) {
                    if (node.value == c) {
                        return node;
                    }
                }
            }
            return null;
        }

        //Проверка есть ли такакя строка в дереве
        private boolean containString(String str) {
            TreeNode current = this;
            for(int i = 0; i < str.length(); i++){
                current = current.findNodeByChar(str.charAt(i));
                if(current == null){
                    return false;
                }
            }
            return true;

        }
        public void getAllNumbers(String path, List<String> result){ // c помощью обхода в глубину делаем
            if(value != ' '){ //проверяем кроневой ли узел по знаку пробела
                path = path + value;
            }
            if(children != null){
                for(TreeNode node: children){
                    node.getAllNumbers(path, result);
                }
            } else {
                result.add(path);
            }

        }

        //сохранения дерева в файл
        //с помощью рекурсии - сохраняем символ после него вызываем функ сохрн
        //для каждого дочернего узла и тд и тд
        public void writeToFile(PrintWriter writer){ // с принтврайтером удобнее
            writer.write(value);
            if(children != null){
                for(TreeNode node: children){
                    node.writeToFile(writer);
                }
            }
            writer.write(']'); // потому что у нас нет квадратной скобки и пожтому я выбрал ее чтобы норм записывалось
        }

        // функция которая считывает с файла
        public void readFromFile(FileReader reader) throws IOException {
            char ch;
            while ((ch =(char)reader.read()) != ']') {
                TreeNode treeNode = new TreeNode(ch);
                treeNode.readFromFile(reader);
                if(children == null){
                    children = new ArrayList<>();
                }
                children.add(treeNode);
            }
        }
    }
    public static void writeTree(String  path, TreeNode root) throws FileNotFoundException {
        try {
            PrintWriter out = new PrintWriter(path);
            root.writeToFile(out);
            out.flush(); // для проверки того чтобы не закрыть файл раньше того как все данные в него записаны
            out.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static TreeNode readFromFile (String path){
        TreeNode root = new TreeNode(' ');
        try {
            FileReader reader = new FileReader(path);
            reader.read();
            root.readFromFile(reader);
            reader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return root;
    }
}