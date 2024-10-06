package dmplz.family_farm_server.question.dto;

import java.time.LocalDateTime;

import dmplz.family_farm_server.question.model.FamilyQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyQuestionDTO {
	private Long familyQuestionId;
	private String questionContent;
	private LocalDateTime allocatedDate;
	private Boolean isComplete;

	public FamilyQuestionDTO(FamilyQuestion familyQuestion) {
		this.familyQuestionId = familyQuestion.getId();
		this.questionContent = familyQuestion.getQuestion().getQuestionContent();
		this.allocatedDate = familyQuestion.getAllocatedDate();
		this.isComplete = familyQuestion.getIsComplete();
	}
}
