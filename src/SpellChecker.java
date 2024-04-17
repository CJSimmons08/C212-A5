import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.List;

public class SpellChecker {

    public static void spellChecker(String dict, String in) throws IOException {
        BufferedReader dictionary = new BufferedReader(new FileReader(dict));
        Scanner file = new Scanner(new FileReader(in)).useDelimiter(" ");
        PrintWriter pw = new PrintWriter(new FileWriter(in.substring(0, in.length() - 3) + ".out"));

        String line;
        List<String> dictList = new ArrayList<>();
        while((line = dictionary.readLine()) != null){
            dictList.add(line);
        }



        String finalString = "";
        String currentWord = file.next();
        while(currentWord != null){
            String dictWord = dictList.get(0);
            boolean correctSpell = false;
            for(int i = 0; i < dictList.size(); i++){
                if(currentWord.equalsIgnoreCase(dictWord)){
                    correctSpell = true;
                    break;
                }
                else{
                    if(i == dictList.size() - 1){
                        continue;
                    }
                    dictWord = dictList.get(i + 1);
                }
            }
            if(file.hasNext()){
                if(correctSpell) {
                    finalString = finalString.concat(currentWord + " ");
                    currentWord = file.next();
                    continue;
                }
                finalString = finalString + "[" + currentWord + "]" + " ";
                currentWord = file.next();
            }
            else{
                if(correctSpell) {
                    finalString = finalString.concat(currentWord + " ");
                    currentWord = null;
                    continue;
                }
                finalString = finalString + "[" + currentWord + "]" + " ";
                currentWord = null;
            }

        }
        pw.print(finalString);
        pw.close();
    }


    public static void main(String[] args) throws IOException {
        spellChecker("C:\\Users\\coshn\\IdeaProjects\\C212-A5\\src\\dictionary.txt", "C:\\Users\\coshn\\IdeaProjects\\C212-A5\\src\\file3a.in");
    }
}
