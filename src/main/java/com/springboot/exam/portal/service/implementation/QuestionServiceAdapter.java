package com.springboot.exam.portal.service.implementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exam.portal.model.exam.Question;
import com.springboot.exam.portal.model.exam.Quiz;
import com.springboot.exam.portal.repository.QuestionRepository;
import com.springboot.exam.portal.service.QuestionService;
@Service
public class QuestionServiceAdapter implements QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<Question>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long quesid) {
		// TODO Auto-generated method stub
		return this.questionRepository.findById(quesid).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long questionId) {
		// TODO Auto-generated method stub
		this.questionRepository.deleteById(questionId);
	}
	

}
