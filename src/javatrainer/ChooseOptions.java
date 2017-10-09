package javatrainer;

import java.util.Scanner;

public class ChooseOptions {
    private JavaLearn javaLearn;
    private JavaQuiz javaQuiz;

    public ChooseOptions(JavaLearn javaLearn, JavaQuiz javaQuiz) {
        this.javaLearn = javaLearn;
        this.javaQuiz = javaQuiz;
    }

    public void chooseLearnOrQuiz() {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String answer = input.next();
            switch (answer.toLowerCase()) {
                case "learn":
                    System.out.println("\nWelcome to Java Learn!\n");
                    javaLearn.begin();
                    chooseAgain();
                    break;
                case "quiz":
                    System.out.println("\nWelcome to Java Quiz!\n");
                    javaQuiz.begin();
                    chooseAgain();
                    break;
                default:
                    System.out.println(Text.notOption);
                    System.out.println(Text.chooseMode);

            }
        }
    }

    public void chooseAgain() {

        System.out.println(Text.exitOrQuiz);
        Scanner input = new Scanner(System.in);
        String answer = input.next();


        switch (answer.toLowerCase()) {
            case "exit":
                System.out.println(Text.goodbye);
                break;
            case "quiz":
                System.out.println("\nWelcome to Java Quiz!\n");
                javaQuiz.begin();
                chooseAgain();
                break;
            case "learn":
                System.out.println("\nWelcome to Java Learn!\n");
                javaLearn.begin();
                chooseAgain();
                break;
            default:
                System.out.println(Text.notOption);
                chooseAgain();
                break;
        }

    }
}

