import java.io.*;
import java.util.Scanner;


public class Capitalize {

    public static void capitalize(String in) throws IOException {
        //BufferedReader file = new BufferedReader(new FileReader(in));
        Scanner file = new Scanner(new FileReader(in)).useDelimiter("\\.");
        PrintWriter pw = new PrintWriter(new FileWriter(in.substring(0, in.length() - 3) + ".out"));

        String sentence = file.next();
        while(sentence != null){
            int firstChar = 0;
            for(int i = 0; i < sentence.length(); i++){
                if(sentence.charAt(i) >= 97 && sentence.charAt(i) <= 122){
                    firstChar = i;
                    break;
                }
            }

            sentence = sentence.substring(0, firstChar) + sentence.substring(firstChar, firstChar + 1).toUpperCase() + sentence.substring(firstChar + 1);

            if(file.hasNext()){
                pw.print(sentence + ".");
                sentence = file.next();
            }
            else{
                pw.print(sentence + ".");
                sentence = null;
            }
        }
        pw.close();

    }

}
