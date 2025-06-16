package com.adv.java.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Answer")
public class AnswerManyToOne {
	
	@Id
	@Column(name="answer_id")
	private int answerId;
	
	@ManyToOne
	private QuestionOneToMany question;
	
	private String answer;
	
	public QuestionOneToMany getQuestion() {
		return question;
	}

	public void setQuestion(QuestionOneToMany question) {
		this.question = question;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
