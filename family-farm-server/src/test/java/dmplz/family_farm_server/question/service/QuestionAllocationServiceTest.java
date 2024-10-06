package dmplz.family_farm_server.question.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.family.service.FamilyService;
import dmplz.family_farm_server.question.dto.CreateQuestion;
import dmplz.family_farm_server.question.model.FamilyQuestion;
import dmplz.family_farm_server.question.model.QuestionType;
import dmplz.family_farm_server.member.dto.SignUp;
import dmplz.family_farm_server.member.model.Member;
import dmplz.family_farm_server.member.service.MemberService;

@SpringBootTest
class QuestionAllocationServiceTest {

	@Autowired
	MemberService memberService;

	@Autowired
	QuestionService questionService;

	@Autowired
	FamilyService familyService;

	@Autowired
	QuestionAllocationService questionAllocationService;

	private final String nickName1 = "홍길동";
	private final String nickName2 = "홍영희";
	private final String nickName3 = "홍철수";

	@Test
	@DisplayName("질문 할당 기능 테스트")
	void allocateQuestion() {
		// 멤버 생성
		SignUp signUp1 = new SignUp(nickName1);
		Member member1 = memberService.createMember(signUp1);
		String inviteCode = member1.getFamily().getInviteCode();

		SignUp signUp2 = new SignUp(nickName2, inviteCode);
		SignUp signUp3 = new SignUp(nickName3, inviteCode);

		Member member2 = memberService.createMember(signUp2);
		Member member3 = memberService.createMember(signUp3);

		// 질문 리스트 생성
		List<CreateQuestion> questions = Arrays.asList(
			new CreateQuestion("가장 좋아하는 노래는?", QuestionType.TEXT),
			new CreateQuestion("가장 좋아하는 색깔은?", QuestionType.TEXT),
			new CreateQuestion("가장 좋아하는 장소의 사진은?", QuestionType.IMAGE),
			new CreateQuestion("지금 먹고 싶은 음식은?", QuestionType.TEXT)
		);

		questionService.createMultiQuestion(questions);

		// 질문 할당
		Family family = member1.getFamily();

		List<FamilyQuestion> familyQuestions = new ArrayList<>();
		familyQuestions.add(questionAllocationService.allocateQuestion(family.getFamilyId()));
		familyQuestions.add(questionAllocationService.allocateQuestion(family.getFamilyId()));
		familyQuestions.add(questionAllocationService.allocateQuestion(family.getFamilyId()));
		familyQuestions.add(questionAllocationService.allocateQuestion(family.getFamilyId()));

		// 평가
		Assertions.assertThat(familyQuestions.stream().distinct().count()).isEqualTo(questions.size());
	}
}