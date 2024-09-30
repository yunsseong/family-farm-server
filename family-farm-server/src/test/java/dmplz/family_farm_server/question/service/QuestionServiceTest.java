package dmplz.family_farm_server.question.service;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dmplz.family_farm_server.question.model.Question;
import dmplz.family_farm_server.question.model.QuestionType;

@SpringBootTest
class QuestionServiceTest {

	@Autowired
	private QuestionService questionService;

	@Test
	void testGetUniqueQuestion() {
		//given
		List<Question> questions = Arrays.asList(
			new Question("가장 좋아하는 노래는?", QuestionType.TEXT),
			new Question("가장 좋아하는 색깔은?", QuestionType.TEXT),
			new Question("가장 좋아하는 장소의 사진은?", QuestionType.IMAGE)
		);

		questionService.createMultiQuestion(questions);

		List<Long> answeredQuestionNumbers = Arrays.asList(1L, 2L);

		//when
		Question uniqueQuestion = questionService.getUniqueQuestion(answeredQuestionNumbers);

		//then
		Assertions.assertThat(uniqueQuestion.getId()).isEqualTo(3L);
	}

}