import com.jazwa.dao.QuestionDao;
import com.jazwa.dao.QuestionDaoImpl;
import com.jazwa.model.Question;
import org.junit.Test;

public class QuestionsTest {
    @Test
    public void addQuestions(){


        Question question = new Question();
        question.setContent("Kto ty jestes?");
        question.setAnswer1("Polak maly");
        question.setAnswer2("Niemiec maly");
        question.setAnswer3("Rusek maly");
        question.setCorrectAnswer("Polak maly");

        QuestionDao questionDao = new QuestionDaoImpl();
        questionDao.create(question);
    }
}
