package example2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<String> listText = new ArrayList<>();
        File file = new File("test.txt");
        Pattern p = Pattern.compile("^За$|^На$|^Біля$|^на$|^Від$|^у$|^З$|^до$|^Після$|^Через$|^Без$|^про$");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
            String temp ;
            while ((temp = br.readLine()) != null) {
                String[] s = temp.split(" ");
                StringBuilder list = new StringBuilder();
                for (String word: s) {
                    Matcher m = p.matcher(word);
                    if (m.find()) {
                        word = "Java";
                    }
                    list.append(word).append(" ");
                }
                listText.add(list.toString().trim().concat("\n"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fr = new FileWriter(file)){
            for (String s: listText) {
                fr.append(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
