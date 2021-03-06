package br.edu.univas.lab6.smartpoll.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Answer generated by hbm2java
 */
@Entity
@Table(name = "answer", schema = "public")
public class Answer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Question question;
	private String answer;
	private List<Result> results = new ArrayList<Result>();

	public Answer() {
	}

	public Answer(Long id, Question question, String answer) {
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public Answer(Long id, Question question, String answer,
			List<Result> results) {
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.results = results;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_gen")
	@SequenceGenerator(name = "answer_gen", sequenceName = "answer_id_seq", allocationSize = 1)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "answer", nullable = false, length = 500)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "answer")
	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
