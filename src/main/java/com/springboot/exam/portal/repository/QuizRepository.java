package com.springboot.exam.portal.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.exam.portal.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	@Modifying
    @Transactional
	@Query(value = "DELETE FROM quiz WHERE qid = ?1", nativeQuery = true)
	public void deleteQuiz(Long qid);
	
	@Modifying
    @Transactional
	@Query(value = "SELECT * FROM quiz WHERE category_cid = ?1 AND is_active=1", nativeQuery = true)
	public Set<Quiz> getQuizByCategoryId(Long cid);
	
	@Modifying
    @Transactional
	@Query(value = "SELECT * FROM quiz WHERE is_active=1", nativeQuery = true)
	public Set<Quiz> getActiveQuiz();
	
	@Modifying
    @Transactional
	@Query(value = "SELECT * FROM quiz WHERE qid = ?1 AND is_active=1", nativeQuery = true)
	public Set<Quiz> getActiveQuizById(Long qid);
}

