package com.springboot.exam.portal.service.implementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exam.portal.model.exam.Quiz;
import com.springboot.exam.portal.repository.QuizRepository;
import com.springboot.exam.portal.service.QuizService;
@Service
public class QuizServiceAdapter implements QuizService {
		@Autowired
		private QuizRepository quizRepository;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizes() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<Quiz>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long qid) {
		// TODO Auto-generated method stub
		return this.quizRepository.findById(qid).get();
	}

	@Override
	public void deleteQuiz(Long qid) {

		this.quizRepository.deleteQuiz(qid);
	}

	@Override
	public Set<Quiz> getQuizByCategoryId(Long cid) {
		// TODO Auto-generated method stub
		
		return new LinkedHashSet<Quiz>(this.quizRepository.getQuizByCategoryId(cid));
	}

	@Override
	public Set<Quiz> getActiveQuiz() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<Quiz>(this.quizRepository.getActiveQuiz());
	}

	@Override
	public Set<Quiz> getActiveQuizById(Long qid) {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.quizRepository.getActiveQuizById(qid)) ;
	}
	
}
