package com.jazwa.dao;

import com.jazwa.model.Question;
import com.jazwa.model.Quiz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class QuestionDaoImpl implements QuestionDao {
    private static final String PERSISTANCE_NAME = "store";
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(PERSISTANCE_NAME);
    @Override
    public List<Question> getAll() {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        List<Question> resultList = em.createQuery("from Question").getResultList();
        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    @Override
    public Optional<Question> get(long id) {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        Question result = (Question)em.createQuery("from Question where id=:id").setParameter("id", id).getSingleResult();
        Optional<Question> question = Optional.ofNullable(result);
        em.getTransaction().commit();
        em.close();
        return question;
    }

    @Override
    public void create(Question question) {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(question);
        em.getTransaction().commit();
        em.close();
    }
}
