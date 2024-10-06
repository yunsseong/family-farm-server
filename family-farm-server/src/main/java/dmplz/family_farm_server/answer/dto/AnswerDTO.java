package dmplz.family_farm_server.answer.dto;

import dmplz.family_farm_server.answer.model.Answer;
import dmplz.family_farm_server.answer.model.AnswerType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDTO {

	private Long memberId;
	private String answer;
	private AnswerType answerType;

}
