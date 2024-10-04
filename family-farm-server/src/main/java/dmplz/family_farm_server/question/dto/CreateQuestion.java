package dmplz.family_farm_server.question.dto;

import dmplz.family_farm_server.question.model.QuestionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateQuestion {

	private String questionContent;
	private QuestionType questionType;

	public CreateQuestion(String questionContent, QuestionType questionType) {
		this.questionContent = questionContent;
		this.questionType = questionType;
	}
}
