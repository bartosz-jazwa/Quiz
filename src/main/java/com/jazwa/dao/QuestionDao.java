package com.jazwa.dao;

import com.jazwa.model.Question;
import com.jazwa.model.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuestionDao {
    List<Question> getAll();
    Optional<Question> get(long id);
    void create(Question question);
}
