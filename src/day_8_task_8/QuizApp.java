package day_8_task_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"1. super", "2. extends", "3. implements", "4. this"},
                2
        ));
        questions.add(new Question(
                "Which collection class does not allow duplicate elements?",
                new String[]{"1. List", "2. Map", "3. Set", "4. ArrayList"},
                3
        ));
        questions.add(new Question(
                "Which method is the entry point of a Java program?",
                new String[]{"1. start()", "2. main()", "3. run()", "4. init()"},
                2
        ));

        int score = 0;

        System.out.println("===== Welcome to the Java Quiz =====\n");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.questionText);
            for (String opt : q.options) {
                System.out.println(opt);
            }
            System.out.print("Your answer: ");
            int answer = sc.nextInt();

            if (answer == q.correctAnswer) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer was: " + q.correctAnswer + "\n");
            }
        }

        // Result
        System.out.println("===== Quiz Finished =====");
        System.out.println("Your Score: " + score + " / " + questions.size());

        sc.close();
    }
}
