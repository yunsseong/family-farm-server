package dmplz.family_farm_server.question.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.family.service.FamilyService;
import dmplz.family_farm_server.question.model.FamilyQuestion;
import dmplz.family_farm_server.question.model.Question;
import dmplz.family_farm_server.question.repository.FamilyQuestionRepository;
import dmplz.family_farm_server.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionAllocationService {

	private final FamilyService familyService;
	private final QuestionRepository questionRepository;
	private final FamilyQuestionRepository familyQuestionRepository;

	@Transactional
	public FamilyQuestion allocateQuestion(Long familyId) {
		Family family = familyService.getFamily(familyId);
		FamilyQuestion familyQuestion = new FamilyQuestion(
			family,
			this.getUniqueQuestion(this.getAllocatedQuestionIds(family))
		);
		return familyQuestionRepository.save(familyQuestion);
	}

	@Transactional(readOnly = true)
	public Question getUniqueQuestion(List<Long> answeredQuestionNumbers) {
		int questionPoolSize = questionRepository.findAll().size();
		long randomQuestionNumber = 0;
		do {
			randomQuestionNumber = (long)(Math.random() * questionPoolSize + 1);
		} while (answeredQuestionNumbers.contains(randomQuestionNumber));
		return questionRepository.findById(randomQuestionNumber)
			.orElseThrow(NoSuchElementException::new);
	}

	@Transactional(readOnly = true)
	public List<Long> getAllocatedQuestionIds(Family family) {
		return familyQuestionRepository.findAllByFamily(family)
			.stream()
			.map(FamilyQuestion::getId)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<Question> getAllocatedQuestions(Long familyId) {
		Family family = familyService.getFamily(familyId);
		return familyQuestionRepository.findAllByFamily(family)
			.stream()
			.map(FamilyQuestion::getQuestion)
			.collect(Collectors.toList());
	}
}
