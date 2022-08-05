package com.springboot.exam.portal.service;

import java.util.Set;

import com.springboot.exam.portal.model.exam.Question;
import com.springboot.exam.portal.model.exam.Quiz;

public interface QuestionService {

		public Question addQuestion(Question question);
		public Question updateQuestion(Question question);
		public Set<Question> getQuestions();
	 	public Question getQuestion(Long quesid);
	 	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
		public void deleteQuestion(Long questionId);
}
