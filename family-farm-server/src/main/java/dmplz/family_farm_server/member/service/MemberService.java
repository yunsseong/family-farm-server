package dmplz.family_farm_server.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmplz.family_farm_server.family.service.FamilyService;
import dmplz.family_farm_server.fcm.model.AlertToken;
import dmplz.family_farm_server.fcm.repository.AlertTokenRepository;
import dmplz.family_farm_server.fcm.service.AlertTokenService;
import dmplz.family_farm_server.member.dto.SignUp;
import dmplz.family_farm_server.member.dto.UpdateMemberDTO;
import dmplz.family_farm_server.member.model.Member;
import dmplz.family_farm_server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final FamilyService familyService;
	private final AlertTokenService alertTokenService;

	@Transactional(readOnly = true)
	public Member getMember(Long id) {
		return memberRepository.findById(id)
			.orElseThrow(NoClassDefFoundError::new);
	}

	@Transactional(readOnly = true)
	public List<Member> getAllMember() {
		return memberRepository.findAll();
	}

	@Transactional
	public Member createMember(SignUp signUp) {
		Member member = memberRepository.save(new Member(signUp));
		AlertToken alertToken = alertTokenService.createAlertToken(signUp.getRegisterAlertToken());
		member.connectAlertToken(alertToken);
		if (signUp.getInviteCode() == null) {
			member.allocateFamily(familyService.createNewFamily());
			return member;
		}
		member.allocateFamily(familyService.getFamilyByInviteCode(signUp.getInviteCode()));
		return member;
	}

	@Transactional
	public Member updateMember(UpdateMemberDTO updateMemberDTO) {
		Member findMember = memberRepository.findById(updateMemberDTO.getMemberId())
			.orElseThrow(NoClassDefFoundError::new);
		return findMember.update(updateMemberDTO);
	}
}
