package dmplz.family_farm_server.question.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmplz.family_farm_server.question.dto.CreateQuestion;
import dmplz.family_farm_server.question.model.Question;
import dmplz.family_farm_server.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {

	private final QuestionRepository questionRepository;

	@Transactional(readOnly = true)
	public Question getQuestion(Long id) {
		return questionRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);
	}

	@Transactional(readOnly = true)
	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	@Transactional
	public Question createQuestion(CreateQuestion createQuestion) {
		return questionRepository.save(new Question(createQuestion));
	}

	public List<Question> createMultiQuestion(List<CreateQuestion> createQuestions) {
		return questionRepository.saveAll(
			createQuestions.stream()
			.map(Question::new)
			.collect(Collectors.toList())
		);
	}

	@Transactional
	public Question updateQuestion(Question question) {
		Question findQuestion = questionRepository.findById(question.getId())
			.orElseThrow(NoSuchElementException::new);

		return questionRepository.save(question);
	}

	@Transactional
	public void deleteQuestion(Long id) {
		Question findQuestion = questionRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);
		questionRepository.delete(findQuestion);
	}
}
