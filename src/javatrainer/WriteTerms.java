package javatrainer;

import java.io.*;
//todo write add terms functions

public class WriteTerms {
    File terms = new File("javaterms.txt");

    public void addTerms( String term, String definition) {

        try {
            FileWriter writer = new FileWriter(terms, true);//appends file instead of rewriting
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.newLine();
            buffer.write(term);
            buffer.newLine();
            buffer.write(definition);
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readTerms(){

        try (FileReader fr = new FileReader(terms)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                try {
                    while (br.ready())
                        System.out.println(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
