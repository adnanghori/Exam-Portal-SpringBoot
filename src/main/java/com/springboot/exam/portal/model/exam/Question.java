package com.springboot.exam.portal.model.exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Question {
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionContent=" + questionContent + ", questionImage="
				+ questionImage + ", option_1=" + option_1 + ", option_2=" + option_2 + ", option_3=" + option_3
				+ ", option_4=" + option_4 + ", questionAnswer=" + questionAnswer + ", givenAnswer=" + givenAnswer
				+ ", quiz=" + quiz + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	@Column(length = 5000)
	private String questionContent;

	private String questionImage;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	//@JsonIgnore
	private  String questionAnswer;
	@Transient
	private String givenAnswer;
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getGivenAnswer() {
		return givenAnswer;
	}
	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getQuestionImage() {
		return questionImage;
	}
	public void setQuestionImage(String questionImage) {
		this.questionImage = questionImage;
	}
	public String getOption_1() {
		return option_1;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	public String getOption_2() {
		return option_2;
	}
	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}
	public String getOption_3() {
		return option_3;
	}
	public void setOption_3(String option_3) {
		this.option_3 = option_3;
	}
	public String getOption_4() {
		return option_4;
	}
	public void setOption_4(String option_4) {
		this.option_4 = option_4;
	}
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public Question(Long questionId, String questionContent, String questionImage, String option_1, String option_2,
			String option_3, String option_4, String questionAnswer, Quiz quiz) {
		super();
		this.questionId = questionId;
		this.questionContent = questionContent;
		this.questionImage = questionImage;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
		this.questionAnswer = questionAnswer;
		this.quiz = quiz;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(String questionContent, String questionImage, String option_1, String option_2, String option_3,
			String option_4, String questionAnswer, Quiz quiz,String givenAnswer) {
		super();
		this.questionContent = questionContent;
		this.questionImage = questionImage;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
		this.questionAnswer = questionAnswer;
		this.quiz = quiz;
		this.givenAnswer = givenAnswer;
	}
	 
	
}
