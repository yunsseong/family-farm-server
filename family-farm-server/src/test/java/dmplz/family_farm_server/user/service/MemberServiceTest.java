package dmplz.family_farm_server.user.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.family.repository.FamilyRepository;
import dmplz.family_farm_server.family.service.FamilyService;
import dmplz.family_farm_server.user.DTO.SignUp;
import dmplz.family_farm_server.user.model.Member;

@SpringBootTest
class MemberServiceTest {

	@Autowired
	MemberService memberService;

	@Autowired
	FamilyService familyService;

	@Autowired
	FamilyRepository familyRepository;

	private final String nickName = "홍길동";
	private final String inviteCode = "A1B2C3";

	@Test
	@DisplayName("가족 구성원 중 처음으로 가입한 사용자")
	void createFirstMember() {
		//given
		SignUp signUp = new SignUp(nickName);

		// //when
		Member member = memberService.createMember(signUp);

		// //then
		System.out.println(member.toString());
		assertThat(member.getFamily().getMembers().getFirst()).isEqualTo(member);
	}

	@Test
	@DisplayName("가족 구성원 중 초대코드로 가입한 사용자")
	void createInvitedMember() {
		//given
		Family family = new Family(inviteCode);
		familyRepository.save(family);
		SignUp signUp = new SignUp(nickName, inviteCode);

		// //when
		Member member = memberService.createMember(signUp);

		// //then
		assertThat(member.getFamily().getInviteCode()).isEqualTo(inviteCode);
		assertThat(member.getFamily().getMembers().getFirst()).isEqualTo(member);
	}
}