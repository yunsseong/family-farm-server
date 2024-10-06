package dmplz.family_farm_server.answer.model;

import dmplz.family_farm_server.member.model.Member;
import dmplz.family_farm_server.question.model.FamilyQuestion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private Long id;

	@ManyToOne
	private FamilyQuestion familyQuestion;

	@ManyToOne
	private Member member;

	private AnswerType answerType;

	private String answer;

	public Answer(FamilyQuestion familyQuestion, Member member, AnswerType answerType, String answer) {
		this.familyQuestion = familyQuestion;
		this.member = member;
		this.answerType = answerType;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer{" +
			"id=" + id +
			", familyQuestion=" + familyQuestion +
			", member=" + member +
			", answerType=" + answerType +
			", answer='" + answer + '\'' +
			'}';
	}
}
