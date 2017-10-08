package javatrainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class JavaQuiz {

    private ArrayList<String> answerSet = new ArrayList();
    private HashMap<Integer, String> answerHash = new HashMap<>();
    private HashMap<String, String> javaTerms = new HashMap<>();
    private Random rand = new Random();
    private int score;
    private String correct;
    private int randomNum;


    public JavaQuiz() {
        JavaTermsDatabase data = new JavaTermsDatabase();
        setJavaTerms(data.javaTerms);
        buildAnswerSet(javaTerms);
    }

    public void begin() {

        Scanner inp = new Scanner(System.in);
        int score = 0;
        int questionNum = 0;
        startPrompt();

        for (String a : javaTerms.keySet()) {
            questionNum += 1;
            String correct = javaTerms.get(a);
            setRandomNum(rand.nextInt((4)));
            removeCorrect(correct);
            buildAnswerHash();
            answerHash.put(randomNum, correct);
            System.out.println("\n" + questionNum + ")  What is a " + a + "\n");
            for (int i : answerHash.keySet()) {
                System.out.println(i + 1 + ": " + answerHash.get(i));
            }
            checkCorrect(inp);
            answerSet.add(correct);
            System.out.println(Text.continueQuiz);
            String answer2 = inp.next();
            if (answer2.toLowerCase().equals("y")) {
                continue;
            } else {
                System.out.println("goodbye!");
                break;
            }
        }
    }

    private void buildAnswerSet(HashMap<String, String> hash) {
        for (String a : hash.keySet()) {
            answerSet.add(hash.get(a));
        }
    }

    private void buildAnswerHash() {
        Collections.shuffle(answerSet);
        for (int i = 0; i < 4; i++) {
            answerHash.put(i, answerSet.get(i));
        }
    }

    private void removeCorrect(String correct) {
        for (int i = 0; i < answerSet.size(); i++) {
            if (answerSet.get(i).equals(correct)) {
                answerSet.remove(i);
            }
        }
    }

    private void checkCorrect(Scanner scanner) {
        while (scanner.hasNext()) {
            int choice = 0;

            String error = "Please print a number";
            try {
                choice = Integer.parseInt(scanner.next());
                if (choice > 4) {
                    System.out.println("Please enter a number between 1 and 4");
                    scanner.next();
                }
            } catch (NumberFormatException e) {
                promptUser();
                scanner.next();
            }
            if ((choice - 1) == randomNum) {
                score += 1;
                System.out.print("Correct! ");
            } else {
                System.out.print("Incorrect ");
            }
            System.out.println("Your score: " + score);
            break;
        }
    }

    private void promptUser() {
        System.out.println("Please enter a number");

    }

    private void startPrompt() {
        System.out.println("Welcome to the Java Quiz!\nSelect the number that corresponds to the correct answer");

    }

    private void setJavaTerms(HashMap<String, String> javaTerms) {
        this.javaTerms = javaTerms;
    }

    private void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }
}
