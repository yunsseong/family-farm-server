package dmplz.family_farm_server.answer.model;

import dmplz.family_farm_server.member.model.Member;
import dmplz.family_farm_server.question.model.FamilyQuestion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private Long id;

	@ManyToOne
	private Member member;

	@ManyToOne
	private FamilyQuestion question;

	private AnswerType answerType;

	private String answer;
}
