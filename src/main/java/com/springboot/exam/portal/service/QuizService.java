package com.springboot.exam.portal.service;

import java.util.Set;

import com.springboot.exam.portal.model.exam.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizes();
	public Quiz getQuiz(Long qid);
	public void deleteQuiz(Long qid);
	public Set<Quiz> getQuizByCategoryId(Long cid);
	public Set<Quiz> getActiveQuiz();
	public Set<Quiz> getActiveQuizById(Long qid);
}
