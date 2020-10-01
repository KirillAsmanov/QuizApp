package ru.asmanov.quizapp.model;

import java.util.List;

public class Question {
    private int id;
    private String text;
    private int quiz_Id;
    //private List<Answer> answers;

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getQuiz_Id() {
        return quiz_Id;
    }

    public void setQuiz_Id(int quiz_Id) {
        this.quiz_Id = quiz_Id;
    }

    /*
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    */
}
