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
            switch (answer.toUpperCase()) {
                case "A":
                    javaLearn.begin();
                    chooseAgain();
                    break;
                case "B":
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
        Scanner input = new Scanner(System.in);
        System.out.println(Text.learnMore);
        String answer = input.next();
        if (answer.equalsIgnoreCase("Y")) {
            javaLearn.begin();
            chooseAgain();
        } else if (answer.equalsIgnoreCase("N")) {
            System.out.println(Text.exitOrQuiz);
            String answer2 = input.next();
            switch (answer2.toLowerCase()) {
                case "exit":
                    System.out.println(Text.goodbye);
                    break;
                case "quiz":
                    System.out.println("go to quiz\n");
                    javaQuiz.begin();
                    chooseLearnOrQuiz();
                    break;
                case "learn":
                    System.out.println("go to quiz\n");
                    javaLearn.begin();
                    chooseLearnOrQuiz();
                    break;
                default:
                    System.out.println(Text.notOption);
                    chooseLearnOrQuiz();
                    break;
            }
        } else {
            System.out.println(Text.notOption);
        }
    }
}

