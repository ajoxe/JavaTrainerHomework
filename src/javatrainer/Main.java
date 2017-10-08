package javatrainer;

public class Main {
    public static void main(String[] args) {
        JavaLearn javaLearn = new JavaLearn();
        JavaQuiz javaQuiz = new JavaQuiz();
        System.out.println(Text.welcome);
        System.out.println(Text.chooseMode);
        ChooseOptions chooseOptions = new ChooseOptions(javaLearn, javaQuiz);
        chooseOptions.chooseLearnOrQuiz();
    }
}