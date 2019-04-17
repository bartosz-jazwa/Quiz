package com.jazwa.dao;

import com.jazwa.model.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizDao {
    List<Quiz> getAll();
    Optional<Quiz> get(long id);
    void create(Quiz quiz);
}
