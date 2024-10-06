package dmplz.family_farm_server.question.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dmplz.family_farm_server.question.dto.CreateQuestion;
import dmplz.family_farm_server.question.dto.FamilyQuestionDTO;
import dmplz.family_farm_server.question.model.FamilyQuestion;
import dmplz.family_farm_server.question.model.Question;
import dmplz.family_farm_server.question.service.QuestionAllocationService;
import dmplz.family_farm_server.question.service.QuestionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

	private final QuestionAllocationService questionAllocationService;
	private final QuestionService questionService;

	@GetMapping("/today/{familyId}")
	public ResponseEntity<FamilyQuestionDTO> getTodayQuestion(@PathVariable Long familyId) {
		return ResponseEntity.ok(new FamilyQuestionDTO(questionAllocationService.allocateQuestion(familyId)));
	}

	@GetMapping
	public ResponseEntity<List<Question>> getAllQuestion() {
		return ResponseEntity.ok(questionService.getAllQuestion());
	}

	@GetMapping("/{familyId}")
	public ResponseEntity<List<FamilyQuestionDTO>> getAllocatedQuestion(@PathVariable Long familyId) {
		return ResponseEntity.ok(questionAllocationService.getAllocatedQuestions(familyId));
	}

	@PostMapping("/create")
	public ResponseEntity<Question> createQuestion(@RequestBody CreateQuestion createQuestion) {
		return ResponseEntity.ok(questionService.createQuestion(createQuestion));
	}

	@PostMapping("/create/multi")
	public ResponseEntity<List<Question>> createMultiQuestion(@RequestBody List<CreateQuestion> createQuestions) {
		return ResponseEntity.ok(questionService.createMultiQuestion(createQuestions));
	}
}
