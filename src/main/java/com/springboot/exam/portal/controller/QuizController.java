package com.springboot.exam.portal.controller;

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

import com.springboot.exam.portal.model.exam.Quiz;
import com.springboot.exam.portal.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	@GetMapping("/")
	public ResponseEntity<?> getQuizes(){
		return ResponseEntity.ok(this.quizService.getQuizes());
	}
	@GetMapping("/{qid}")
	public Quiz getQuiz(@PathVariable("qid")Long qid) {
		return this.quizService.getQuiz(qid);
	}
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable("qid")Long qid){
		this.quizService.deleteQuiz(qid);
		//return ResponseEntity.ok("Deleted");
	}
	@GetMapping("/category/{cid}")
	public ResponseEntity<?> getQuizByCategory(@PathVariable("cid")Long cid){
		return ResponseEntity.ok(this.quizService.getQuizByCategoryId(cid));
	}
	@GetMapping("/active-quiz")
	public ResponseEntity<?> getActiveQuiz(){
		return ResponseEntity.ok(this.quizService.getActiveQuiz()); 
	}
	@GetMapping("/active-quiz/{qid}")
	public ResponseEntity<?> getActiveQuizById(@PathVariable("qid")Long qid){
		return ResponseEntity.ok(this.quizService.getActiveQuizById(qid));
	}
}
