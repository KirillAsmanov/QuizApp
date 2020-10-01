package ru.asmanov.quizapp.dao;

import org.springframework.stereotype.Repository;
import ru.asmanov.quizapp.model.Question;
import ru.asmanov.quizapp.model.Quiz;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {
    @Override
    public List<Question> allQuestion(Quiz quiz) {
        return new ArrayList<>(quiz.getQuestionsMap().values());
    }

    @Override
    public void add(Quiz quiz, Question question) {
        quiz.getQuestionsMap().put(question.getId(), question);
    }

    @Override
    public void delete(Quiz quiz, Question question) {
        quiz.getQuestionsMap().remove(question.getId());
    }

    @Override
    public void edit(Quiz quiz, Question question) {
        quiz.getQuestionsMap().put(question.getId(), question);
    }

    @Override
    public Question getById(Quiz quiz, int id) {
        return quiz.getQuestionsMap().get(id);
    }
}
