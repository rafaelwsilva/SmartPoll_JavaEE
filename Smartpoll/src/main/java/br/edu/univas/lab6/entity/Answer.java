package br.edu.univas.lab6.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	private int id;
	private Question question;
	private String answerId;
	private Date dateVote;
	private Set<Result> results = new HashSet<Result>(0);

	public Answer() {
	}

	public Answer(int id, Question question, String answerId, Date dateVote) {
		this.id = id;
		this.question = question;
		this.answerId = answerId;
		this.dateVote = dateVote;
	}

	public Answer(int id, Question question, String answerId, Date dateVote,
			Set<Result> results) {
		this.id = id;
		this.question = question;
		this.answerId = answerId;
		this.dateVote = dateVote;
		this.results = results;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue ( strategy = GenerationType . SEQUENCE ,generator ="answer_gen")
	@SequenceGenerator ( name ="answer_gen", sequenceName ="answer_id_seq", allocationSize =1)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	@Column(name = "answer_id", nullable = false, length = 500)
	public String getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_vote", nullable = false, length = 29)
	public Date getDateVote() {
		return this.dateVote;
	}

	public void setDateVote(Date dateVote) {
		this.dateVote = dateVote;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "answer")
	public Set<Result> getResults() {
		return this.results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}

}
