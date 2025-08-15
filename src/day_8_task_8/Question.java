package day_8_task_8;

public class Question {
    String questionText;
    String [] options;
    int correctAnswer;

    Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}
