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
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
    QuizDao quizDao = new QuizDaoImpl();
    QuestionDao questionDao = new QuestionDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        long id = Long.parseLong(idString);


        Quiz quiz = quizDao.get(id).get();
        Set<Question> questionSet = quiz.getQuestionSet();
        List<Question> questionList = new ArrayList<>(questionSet);
        req.setAttribute("questions",questionList);
        req.getRequestDispatcher("/questions.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AtomicInteger count = new AtomicInteger(0);
        req.getParameterMap().forEach((key, value) -> {
            Question q = questionDao.get(Long.parseLong(key)).get();
            String answer = value[0];
            if (answer.equals(q.getCorrectAnswer())) {
                count.getAndAdd(1);
            }
        });

        req.setAttribute("result",count.get());
        req.getRequestDispatcher("/result.jsp").forward(req,resp);

    }
}
