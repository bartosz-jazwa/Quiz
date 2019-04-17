package com.jazwa.dao;

import com.jazwa.model.Quiz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class QuizDaoImpl implements QuizDao {
    private static final String PERSISTANCE_NAME = "store";
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(PERSISTANCE_NAME);
    @Override
    public List<Quiz> getAll() {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        List<Quiz> resultList = em.createQuery("from Quiz").getResultList();
        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    @Override
    public Optional<Quiz> get(long id) {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        Quiz result = (Quiz)em.createQuery("from Quiz where id=:id").setParameter("id", id).getSingleResult();
        Optional<Quiz> quiz = Optional.ofNullable(result);
        em.getTransaction().commit();
        em.close();
        return quiz;
    }

    @Override
    public void create(Quiz quiz) {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(quiz);
        em.getTransaction().commit();
        em.close();
    }

}
