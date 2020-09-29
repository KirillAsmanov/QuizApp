package ru.asmanov.quizapp.model;

import java.util.Date;
import java.util.List;

public class Quiz {
    private int id;
    private String name;
    private int questionCount;
    private List<Question> questionsList;
    private Date createDate;

    public Quiz() {
        this.createDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
