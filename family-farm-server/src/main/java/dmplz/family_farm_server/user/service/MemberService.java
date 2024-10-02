package dmplz.family_farm_server.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dmplz.family_farm_server.family.service.FamilyService;
import dmplz.family_farm_server.user.DTO.SignUp;
import dmplz.family_farm_server.user.model.Member;
import dmplz.family_farm_server.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final FamilyService familyService;

	public Member getMember(Long id) {
		return memberRepository.findById(id)
			.orElseThrow(NoClassDefFoundError::new);
	}

	public List<Member> getAllMember() {
		return memberRepository.findAll();
	}

	public Member createMember(SignUp signUp) {
		Member member = new Member(signUp.getNickname());
		if (signUp.getInviteCode() == null) {
			member.allocateFamily(familyService.createNewFamily());
			return memberRepository.save(member);
		}

		member.allocateFamily(familyService.getFamilyByInviteCode(signUp.getInviteCode()));
		return memberRepository.save(member);
	}
}
