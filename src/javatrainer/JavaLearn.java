package javatrainer;

import java.util.*;

public class JavaLearn extends JavaTermsDatabase {

    public void begin() {
        System.out.print("Choose one of the following terms to learn more (type 'quit' to quit at any time): \n\n");
        for (String a : javaTerms.keySet()) {
            System.out.print(a + " ; ");
        }
        System.out.println("\n");

        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String term1 = input.nextLine().toLowerCase();
            if (term1.toLowerCase().equals("quit")) {
                System.out.println("*Java Learn ended.\n");
                break;
            }
            if (javaTerms.containsKey(term1)) {
                System.out.println(javaTerms.get(term1) + "\n");
            } else {
                System.out.println(Text.notOption);
            }
        }
    }
}