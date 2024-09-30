package dmplz.family_farm_server.question.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dmplz.family_farm_server.question.model.Question;
import dmplz.family_farm_server.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {

	private final QuestionRepository questionRepository;

	public Question getQuestion(Long id) {
		return questionRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);
	}

	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	public Question getUniqueQuestion(List<Long> answeredQuestionNumbers) {
		int questionPoolSize = questionRepository.findAll().size();
		long randomQuestionNumber = 0;
		do {
			 randomQuestionNumber = (long)(Math.random() * questionPoolSize + 1);
		} while (answeredQuestionNumbers.contains(randomQuestionNumber));
		return questionRepository.findById(randomQuestionNumber)
			.orElseThrow(NoSuchElementException::new);
	}

	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}

	public List<Question> createMultiQuestion(List<Question> questions) {
		return questionRepository.saveAll(questions);
	}

	public Question updateQuestion(Question question) {
		Question findQuestion = questionRepository.findById(question.getId())
			.orElseThrow(NoSuchElementException::new);

		return questionRepository.save(question);
	}

	public void deleteQuestion(Long id) {
		Question findQuestion = questionRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);
		questionRepository.delete(findQuestion);
	}
}
