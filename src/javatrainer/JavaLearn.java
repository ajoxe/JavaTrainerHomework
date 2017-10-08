package javatrainer;
import java.util.*;
public class JavaLearn {

    private HashMap<String, String> javaTerms = new HashMap<>();


    public JavaLearn(){

        JavaTermsDatabase data = new JavaTermsDatabase();
        setJavaTerms(data.javaTerms);
    }
    private void setJavaTerms(HashMap<String, String> javaTerms) {
        this.javaTerms = javaTerms;
    }

    public void begin() {
        System.out.println("Choose one of the following terms to learn more:\n");
        for (String a : javaTerms.keySet()) {
            System.out.print(a + " ; ");
        }
        System.out.println("\n");

        Scanner input = new Scanner(System.in);

        String term1 = input.nextLine().toLowerCase();
        if (javaTerms.containsKey(term1)) {
            System.out.println(javaTerms.get(term1) + "\n");
        } else {
            System.out.println(Text.notOption);
        }
        for (String terms : javaTerms.keySet()) {
            if (term1.equals(terms)) {
                javaTerms.get(terms);
            }
        }

    }
}