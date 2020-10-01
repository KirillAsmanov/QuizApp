package ru.asmanov.quizapp.model;

import java.util.Date;
import java.util.Map;

public class Quiz {
    private int id;
    private String name;
    private String description;
    private Map<Integer ,Question> questionsMap;
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

    public Map<Integer ,Question> getQuestionsMap() {
        return questionsMap;
    }

    public void setQuestionsMap(Map<Integer ,Question> questionsMap) {
        this.questionsMap = questionsMap;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
