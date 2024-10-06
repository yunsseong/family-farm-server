package dmplz.family_farm_server.answer.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dmplz.family_farm_server.answer.dto.AnswerDTO;
import dmplz.family_farm_server.answer.dto.AnswerResponseDTO;
import dmplz.family_farm_server.answer.model.Answer;
import dmplz.family_farm_server.answer.repository.AnswerRepository;
import dmplz.family_farm_server.member.model.Member;
import dmplz.family_farm_server.member.service.MemberService;
import dmplz.family_farm_server.question.model.FamilyQuestion;
import dmplz.family_farm_server.question.service.FamilyQuestionService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {

	private final AnswerRepository answerRepository;
	private final MemberService	memberService;
	private final FamilyQuestionService familyQuestionService;

	public AnswerResponseDTO answerQuestion(Long familyQuestionId, AnswerDTO answerDTO) {
		FamilyQuestion familyQuestion = familyQuestionService.getFamilyQuestion(familyQuestionId);
		Member member = memberService.getMember(answerDTO.getMemberId());
		if(!familyQuestion.getQuestion().getQuestionType().toString().equals(answerDTO.getAnswerType().toString()))
			throw new IllegalArgumentException();
		Answer answer = answerRepository.save(new Answer(familyQuestion, member, answerDTO.getAnswerType(), answerDTO.getAnswer()));
		return new AnswerResponseDTO(answer);
	}

	public List<AnswerResponseDTO> getAnswers(Long familyQuestionId) {
		FamilyQuestion familyQuestion = familyQuestionService.getFamilyQuestion(familyQuestionId);
		return answerRepository.findByFamilyQuestion(familyQuestion)
			.orElseThrow(NoSuchElementException::new)
			.stream()
			.map(AnswerResponseDTO::new)
			.collect(Collectors.toList());
	}

	public AnswerResponseDTO getAnswer(Long answerId) {
		return new AnswerResponseDTO(answerRepository.findById(answerId)
			.orElseThrow(NoSuchElementException::new));
	}
}
