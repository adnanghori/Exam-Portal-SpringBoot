package com.springboot.exam.portal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.exam.portal.model.exam.Question;
import com.springboot.exam.portal.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	public Set<Question> findByQuiz(Quiz quiz);

}
