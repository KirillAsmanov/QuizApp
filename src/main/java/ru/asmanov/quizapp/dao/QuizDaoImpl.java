package ru.asmanov.quizapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.asmanov.quizapp.model.Question;
import ru.asmanov.quizapp.model.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class QuizDaoImpl implements QuizDao{
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static final AtomicInteger AUTO_QUEST_ID = new AtomicInteger(0);
    public static Map<Integer, Quiz> quizzes = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(QuizDaoImpl.class);

    static {
        Quiz quiz1 = new Quiz();
        HashMap<Integer, Question> questions1 = new HashMap<Integer, Question>();
        Question q1 = new Question(AUTO_QUEST_ID.getAndIncrement(), "Вопрос1");
        Question q2 = new Question(AUTO_QUEST_ID.getAndIncrement(), "Вопрос2");
        questions1.put(q1.getId(), q1);
        questions1.put(q2.getId(), q2);
        quiz1.setId(AUTO_ID.getAndIncrement());
        quiz1.setName("Полина сосиська");
        quiz1.setQuestionsMap(questions1);

        quizzes.put(quiz1.getId(), quiz1);

        Quiz quiz2 = new Quiz();
        quiz2.setId(AUTO_ID.getAndIncrement());
        quiz2.setName("Сосиська Полина");
        quiz2.setQuestionsMap(null);

        quizzes.put(quiz2.getId(), quiz2);

        // + film2, film3, film4, ...
    }
    @Override
    public List<Quiz> allQuiz() {
        List<Quiz> quizList = new ArrayList<>(quizzes.values());
        logger.info("Quiz list: ");
        for (Quiz quiz : quizList) {
            logger.info("Quiz: " + quiz);
        }
        return quizList;
    }

    @Override
    public void add(Quiz quiz) {
        quiz.setId(AUTO_ID.getAndIncrement());
        quizzes.put(quiz.getId(), quiz);
        logger.info("Quiz successfully added: " + quiz);
    }

    @Override
    public void delete(Quiz quiz) {
        quizzes.remove(quiz.getId());
        logger.info("Quiz successfully removed: " + quiz);
    }

    @Override
    public void edit(Quiz quiz) {
        quizzes.put(quiz.getId(), quiz);
        logger.info("Quiz successfully changed: " + quiz);
    }

    @Override
    public Quiz getById(int id) {
        Quiz quiz = quizzes.get(id);
        logger.info("Quiz successfully added: " + quiz);
        return quiz;
    }

    @Override
    public List<Question> allQuestion(Quiz quiz) {
        List<Question> questionList = new ArrayList<>(quiz.getQuestionsMap().values());
        return questionList;
    }
}
