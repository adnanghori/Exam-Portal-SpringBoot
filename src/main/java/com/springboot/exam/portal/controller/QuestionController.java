package com.springboot.exam.portal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exam.portal.model.exam.Question;
import com.springboot.exam.portal.model.exam.Quiz;
import com.springboot.exam.portal.service.QuestionService;
import com.springboot.exam.portal.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

		@Autowired
		private QuestionService questionService;
		@Autowired
		private QuizService quizService;
		
		@PostMapping("/")
		public ResponseEntity<Question> addQuestion(@RequestBody Question question){
			return ResponseEntity.ok(this.questionService.addQuestion(question));
		}
		@PutMapping("/")
		public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
			return ResponseEntity.ok(this.questionService.updateQuestion(question));
		}
		@GetMapping("/")
		public ResponseEntity<?> getAllQuestion(){
			return ResponseEntity.ok(this.questionService.getQuestions());
		}
		@GetMapping("/quiz/{qid}")
		public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid")Long qid){
			Quiz quiz = this.quizService.getQuiz(qid);
			Set<Question> questions = quiz.getQuestions();
			List list = new ArrayList(questions);
			if(list.size()>Integer.parseInt(quiz.getNumberOfQuestion())) {
				list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion()+1));
			}
			Collections.shuffle(list);
			return ResponseEntity.ok(list);
		}
		@GetMapping("/{questionId}")
		public Question getQuestion(@PathVariable("questionId")Long questionId) {
			return this.questionService.getQuestion(questionId);
		}
		@DeleteMapping("/{questionId}")
		public void deleteQuestion(@PathVariable("questionId")Long questionId){
			this.questionService.deleteQuestion(questionId);
			//return ResponseEntity.ok("Deleted");
		}
		
		@GetMapping("/active-quiz/{qid}")
		public ResponseEntity<?> getQuestionsOfActiveQuiz(@PathVariable("qid")Long qid){
			Quiz quiz = this.quizService.getQuiz(qid);
			if(quiz.getIsActive()==false) {
				ResponseEntity.noContent().build();
			}
			else {
				Set<Question> questions = quiz.getQuestions();
				List <Question>list = new ArrayList<Question>(questions);
				if(list.size()>Integer.parseInt(quiz.getNumberOfQuestion())) {
					list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion()+1));
				}
				Collections.shuffle(list);
				return ResponseEntity.ok(list);
			}
			return ResponseEntity.notFound().build();
		}
		
		// evaluate quiz
		@PostMapping("/evaluate-quiz")
		public ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions){
			Double marksGot=0D;
			Integer correctAnswer = 0;
			Integer attemptedQuestions = 0;
			Double mark = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
			for(Question q : questions)
			{
				Question question = this.questionService.getQuestion(q.getQuestionId());
				if(question.getQuestionAnswer().trim().equals(q.getGivenAnswer())) {
					// correct answer
					correctAnswer++;
				}
				 if(q.getGivenAnswer()!=null){
					
					 attemptedQuestions++;      
				 }
			}
			marksGot = mark*correctAnswer;
			Map<String, Object> map = Map.of("marksGot",marksGot,"correctAnswer",correctAnswer,"attemptedQuestions",attemptedQuestions);
			return ResponseEntity.ok(map);
		}
}
