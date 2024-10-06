package dmplz.family_farm_server.question.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.family.service.FamilyService;
import dmplz.family_farm_server.question.dto.FamilyQuestionDTO;
import dmplz.family_farm_server.question.model.FamilyQuestion;
import dmplz.family_farm_server.question.model.Question;
import dmplz.family_farm_server.question.repository.FamilyQuestionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionAllocationService {

	private final FamilyService familyService;
	private final QuestionService questionService;
	private final FamilyQuestionService familyQuestionService;

	@Transactional
	public FamilyQuestion allocateQuestion(Long familyId) {
		Family family = familyService.getFamily(familyId);
		FamilyQuestion familyQuestion = new FamilyQuestion(
			family,
			this.getUniqueQuestion(this.getAllocatedQuestionIds(family))
		);
		return familyQuestionService.createFamilyQuestion(familyQuestion);
	}

	@Transactional(readOnly = true)
	public Question getUniqueQuestion(List<Long> answeredQuestionIds) {
		int questionPoolSize = questionService.getAllQuestion().size();
		long randomId = 0;
		do {
			randomId = (long)(Math.random() * questionPoolSize + 1);
		} while (answeredQuestionIds.contains(randomId));
		return questionService.getQuestion(randomId);
	}

	@Transactional(readOnly = true)
	public List<Long> getAllocatedQuestionIds(Family family) {
		return familyQuestionService.getFamilyQuestions(family)
			.stream()
			.map(FamilyQuestion::getId)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public FamilyQuestionDTO getAllocatedQuestion(Long familyId, Long questionId) {
		return new FamilyQuestionDTO(familyQuestionService.getFamilyQuestion(familyId, questionId));
	}

	@Transactional(readOnly = true)
	public List<FamilyQuestionDTO> getAllocatedQuestions(Long familyId) {
		return familyQuestionService.getFamilyQuestions(familyId).stream()
			.map(FamilyQuestionDTO::new)
			.collect(Collectors.toList());
	}
}
