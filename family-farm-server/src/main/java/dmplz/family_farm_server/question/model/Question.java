package dmplz.family_farm_server.question.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column
	private String questionContent;

	@Column
	private Enum questionType;

	public Question(String questionContent, Enum questionType) {
		this.questionContent = questionContent;
		this.questionType = questionType;
	}
}
