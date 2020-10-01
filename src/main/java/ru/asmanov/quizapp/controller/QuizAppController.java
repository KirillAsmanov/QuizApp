package ru.asmanov.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.asmanov.quizapp.model.Question;
import ru.asmanov.quizapp.model.Quiz;
import ru.asmanov.quizapp.service.QuestionService;
import ru.asmanov.quizapp.service.QuizService;

import java.util.List;

@Controller
public class QuizAppController {
    private QuizService quizService;
    private QuestionService questionService;

    @Autowired
    public QuizAppController(QuizService quizService, QuestionService questionService) {
        this.quizService = quizService;
        this.questionService = questionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allQuizzes() {
        List<Quiz> quizList = quizService.allQuiz();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("quizList", quizList);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Quiz quiz = quizService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("quiz", quiz);
        List<Question> questionList = questionService.allQuestion(quiz);
        modelAndView.addObject("questionList", questionList);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editQuiz(@ModelAttribute("quiz") Quiz quiz) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        quizService.edit(quiz);
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute("quiz") Quiz quiz) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        quizService.add(quiz);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Quiz quiz = quizService.getById(id);
        quizService.delete(quiz);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}/{question_id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id, @PathVariable("question_id") int questionId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/edit/{id}");
        Quiz quiz = quizService.getById(id);
        Question question = questionService.getById(quiz, questionId);
        questionService.delete(quiz, question);
        return modelAndView;
    }
}
