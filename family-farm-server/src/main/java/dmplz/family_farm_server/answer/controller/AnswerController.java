package dmplz.family_farm_server.answer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dmplz.family_farm_server.answer.dto.AnswerDTO;
import dmplz.family_farm_server.answer.dto.AnswerResponseDTO;
import dmplz.family_farm_server.answer.model.Answer;
import dmplz.family_farm_server.answer.service.AnswerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

	private final AnswerService answerService;

	@GetMapping("/{answerId}")
	public ResponseEntity<AnswerResponseDTO> getAnswer(@PathVariable Long answerId) {
		return ResponseEntity.ok(answerService.getAnswer(answerId));
	}

	@GetMapping("/family/{familyQuestionId}")
	public ResponseEntity<List<AnswerResponseDTO>> getAnswers(@PathVariable Long familyQuestionId) {
		return ResponseEntity.ok(answerService.getAnswers(familyQuestionId));
	}

	@PostMapping("/{familyQuestionId}")
	public ResponseEntity<AnswerResponseDTO> answerQuestion(@PathVariable Long familyQuestionId, @RequestBody AnswerDTO answerDTO) {
		return ResponseEntity.ok(answerService.answerQuestion(familyQuestionId, answerDTO));
	}
}
