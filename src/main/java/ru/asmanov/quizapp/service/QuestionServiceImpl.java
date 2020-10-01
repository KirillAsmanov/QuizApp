package ru.asmanov.quizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asmanov.quizapp.dao.QuestionDao;
import ru.asmanov.quizapp.dao.QuestionDaoImpl;
import ru.asmanov.quizapp.dao.QuizDaoImpl;
import ru.asmanov.quizapp.model.Question;
import ru.asmanov.quizapp.model.Quiz;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    QuestionDao questionDao;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> allQuestion(Quiz quiz) {
        return questionDao.allQuestion(quiz);
    }

    @Override
    public void add(Quiz quiz, Question question) {
        questionDao.add(quiz, question);
    }

    @Override
    public void delete(Quiz quiz, Question question) {
        questionDao.delete(quiz, question);
    }

    @Override
    public void edit(Quiz quiz, Question question) {
        questionDao.edit(quiz, question);
    }

    @Override
    public Question getById(Quiz quiz, int id) {
        return questionDao.getById(quiz, id);
    }
}
