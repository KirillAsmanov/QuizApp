package ru.asmanov.quizapp.service;

import ru.asmanov.quizapp.model.Quiz;

import java.util.List;

public interface QuizService {
    List<Quiz> allQuiz();
    void add(Quiz quiz);
    void delete(Quiz quiz);
    void edit(Quiz quiz);
    Quiz getById(int id);
}
