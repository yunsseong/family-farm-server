package dmplz.family_farm_server.question.model;

import java.time.LocalDateTime;
import dmplz.family_farm_server.family.model.Family;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class FamilyQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Family family;

	@ManyToOne(fetch = FetchType.EAGER)
	private Question question;

	private LocalDateTime allocatedDate;

	private Boolean isComplete;

	public FamilyQuestion(Family family, Question uniqueQuestion) {
		this.family = family;
		this.question = uniqueQuestion;
		this.allocatedDate = LocalDateTime.now();
		this.isComplete = false;
	}

	@Override
	public String toString() {
		return "FamilyQuestion{" +
			"id=" + id +
			", family=" + family.toString() +
			", question=" + question.toString() +
			", allocatedDate=" + allocatedDate +
			", isComplete=" + isComplete +
			'}';
	}
}
