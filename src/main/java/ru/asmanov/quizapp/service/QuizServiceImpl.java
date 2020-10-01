package ru.asmanov.quizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asmanov.quizapp.dao.QuizDao;
import ru.asmanov.quizapp.dao.QuizDaoImpl;
import ru.asmanov.quizapp.model.Question;
import ru.asmanov.quizapp.model.Quiz;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    private QuizDao quizDao;

    @Autowired
    public QuizServiceImpl(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    @Override
    public List<Quiz> allQuiz() {
        return quizDao.allQuiz();
    }

    @Override
    public void add(Quiz quiz) {
        quizDao.add(quiz);
    }

    @Override
    public void delete(Quiz quiz) {
        quizDao.delete(quiz);
    }

    @Override
    public void edit(Quiz quiz) {
        quizDao.edit(quiz);
    }

    @Override
    public Quiz getById(int id) {
        return quizDao.getById(id);
    }
}
