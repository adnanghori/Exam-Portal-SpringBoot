package com.springboot.exam.portal.model.exam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long qid;
		private String quizTitle;
		private String quizDescription;
		private String maxMarks;
		private String numberOfQuestion;
		private Boolean isActive = false;
		@ManyToOne(fetch = FetchType.EAGER)
		private Category category;
		@OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		@JsonIgnore
		private Set<Question> questions = new HashSet<>();
		public Quiz() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Quiz(String quizTitle, String quizDescription, String maxMarks, String numberOfQuestion,
				Boolean isActive) {
			super();
			this.quizTitle = quizTitle;
			this.quizDescription = quizDescription;
			this.maxMarks = maxMarks;
			this.numberOfQuestion = numberOfQuestion;
			this.isActive = isActive;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public Long getQid() {
			return qid;
		}

		public void setQid(Long qid) {
			this.qid = qid;
		}

		public String getQuizTitle() {
			return quizTitle;
		}

		public void setQuizTitle(String quizTitle) {
			this.quizTitle = quizTitle;
		}

		public String getQuizDescription() {
			return quizDescription;
		}

		public void setQuizDescription(String quizDescription) {
			this.quizDescription = quizDescription;
		}

		public String getMaxMarks() {
			return maxMarks;
		}

		public void setMaxMarks(String maxMarks) {
			this.maxMarks = maxMarks;
		}

		public String getNumberOfQuestion() {
			return numberOfQuestion;
		}

		public void setNumberOfQuestion(String numberOfQuestion) {
			this.numberOfQuestion = numberOfQuestion;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}

		public Set<Question> getQuestions() {
			return questions;
		}

		public void setQuestions(Set<Question> questions) {
			this.questions = questions;
		}
		
		
}
