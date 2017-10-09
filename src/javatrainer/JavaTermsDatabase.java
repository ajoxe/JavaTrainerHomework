package javatrainer;
//google tokenizer or split function.

import java.io.*;
import java.util.HashMap;

public class JavaTermsDatabase {

    static HashMap <String, String> javaTerms = new HashMap<>();
    File terms = new File("javaterms.txt");

    public JavaTermsDatabase(){
        javaTerms = addToHash();
    }

    public HashMap<String, String>addToHash(){
        try {
            FileReader fr = new FileReader(terms);
            BufferedReader br = new BufferedReader(fr);
                try {
                    while (br.ready()) {
                        javaTerms.put(br.readLine(), br.readLine());
                    }
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaTerms;
    }
}
