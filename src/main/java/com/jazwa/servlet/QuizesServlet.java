package com.jazwa.servlet;

import com.jazwa.dao.QuestionDao;
import com.jazwa.dao.QuestionDaoImpl;
import com.jazwa.dao.QuizDao;
import com.jazwa.dao.QuizDaoImpl;
import com.jazwa.model.Question;
import com.jazwa.model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/quizServ")
public class QuizesServlet extends HttpServlet {
    private final QuizDao quizDao = new QuizDaoImpl();
    private final QuestionDao questionDao = new QuestionDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Question question = new Question();
        question.setContent("Kto ty jestes?");
        question.setAnswer1("Polak maly");
        question.setAnswer2("Niemiec maly");
        question.setAnswer3("Rusek maly");
        question.setCorrectAnswer("A");

        Question question2 = new Question();
        question2.setContent("Jaki znak twoj?");
        question2.setAnswer1("Orzel bialy");
        question2.setAnswer2("Czarna wrona");
        question2.setAnswer3("Jakis ptak");
        question2.setCorrectAnswer("B");

        Quiz quiz = new Quiz();
        quiz.setTitle("Wiedza o wierszykach");
        question.setQuiz(quiz);
        question2.setQuiz(quiz);


        Set<Question> questionSet = new HashSet<>();
        questionSet.add(question);
        questionSet.add(question2);
        quiz.setQuestionSet(questionSet);
        quizDao.create(quiz);
        //questionDao.create(question);





        List<Quiz> quizzes = quizDao.getAll();
        req.setAttribute("quizzes",quizzes);
        req.getRequestDispatcher("/quizes.jsp").forward(req,resp);
    }
}
