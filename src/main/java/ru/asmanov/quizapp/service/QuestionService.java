package ru.asmanov.quizapp.service;

import ru.asmanov.quizapp.model.Question;
import ru.asmanov.quizapp.model.Quiz;

import java.util.List;

public interface QuestionService {
    List<Question> allQuestion(Quiz quiz);
    void add(Quiz quiz, Question question);
    void delete(Quiz quiz, Question question);
    void edit(Quiz quiz, Question question);
    Question getById(Quiz quiz, int id);
}
