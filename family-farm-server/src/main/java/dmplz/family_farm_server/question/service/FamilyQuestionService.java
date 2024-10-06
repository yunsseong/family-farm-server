package dmplz.family_farm_server.question.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.family.service.FamilyService;
import dmplz.family_farm_server.question.model.FamilyQuestion;
import dmplz.family_farm_server.question.model.Question;
import dmplz.family_farm_server.question.repository.FamilyQuestionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyQuestionService {

	private final FamilyQuestionRepository familyQuestionRepository;
	private final FamilyService familyService;
	private final QuestionService questionService;

	public List<FamilyQuestion> getFamilyQuestions(Long familyId) {
		return familyQuestionRepository
			.findAllByFamily(familyService.getFamily(familyId))
			.orElseThrow(NoClassDefFoundError::new);
	}

	public List<FamilyQuestion> getFamilyQuestions(Family family) {
		return familyQuestionRepository
			.findAllByFamily(family)
			.orElseThrow(NoClassDefFoundError::new);
	}

	public FamilyQuestion getFamilyQuestion(Long id) {
		return familyQuestionRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);
	}

	public FamilyQuestion getFamilyQuestion(Long familyId, Long questionId) {
		Family family = familyService.getFamily(familyId);
		Question question = questionService.getQuestion(questionId);
		return familyQuestionRepository.findByFamilyAndQuestion(family, question)
			.orElseThrow(NoClassDefFoundError::new);
	}

	public FamilyQuestion createFamilyQuestion(FamilyQuestion familyQuestion) {
		return familyQuestionRepository.save(familyQuestion);
	}
}
