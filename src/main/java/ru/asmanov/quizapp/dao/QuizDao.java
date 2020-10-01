package ru.asmanov.quizapp.dao;

import ru.asmanov.quizapp.model.Question;
import ru.asmanov.quizapp.model.Quiz;

import java.util.List;

public interface QuizDao {
    List<Quiz> allQuiz();
    void add(Quiz quiz);
    void delete(Quiz quiz);
    void edit(Quiz quiz);
    Quiz getById(int id);
    List<Question> allQuestion(Quiz quiz);
}
