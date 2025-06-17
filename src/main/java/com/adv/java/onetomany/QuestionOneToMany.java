package com.adv.java.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Question")
public class QuestionOneToMany {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	
	private String question;
	
	@OneToMany(mappedBy="question", fetch=FetchType.EAGER)
	private List<AnswerManyToOne> answer;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerManyToOne> getAnswer() {
		return answer;
	}

	public void setAnswer(List<AnswerManyToOne> answer) {
		this.answer = answer;
	}

	
	

}
