package dmplz.family_farm_server.answer.dto;

import dmplz.family_farm_server.answer.model.Answer;
import dmplz.family_farm_server.answer.model.AnswerType;
import dmplz.family_farm_server.question.model.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerResponseDTO {

	private Long answerId;
	private String question;
	private Long memberId;
	private String answer;
	private AnswerType answerType;

	public AnswerResponseDTO(Answer answer) {
		this.answerId = answer.getId();
		this.question = answer.getFamilyQuestion().getQuestion().getQuestionContent();
		this.memberId = answer.getMember().getMemberId();
		this.answer = answer.getAnswer();
		this.answerType = answer.getAnswerType();
	}
}
