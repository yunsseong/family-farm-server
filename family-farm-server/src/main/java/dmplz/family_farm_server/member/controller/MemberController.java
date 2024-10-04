package dmplz.family_farm_server.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dmplz.family_farm_server.member.dto.UpdateMemberDTO;
import dmplz.family_farm_server.member.model.Member;
import dmplz.family_farm_server.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/{memberId}")
	public ResponseEntity<Member> getMember(@PathVariable Long memberId) {
		return ResponseEntity.ok(memberService.getMember(memberId));
	}

	@GetMapping("/update/{memberId}")
	public ResponseEntity<Member> updateMember(@RequestBody UpdateMemberDTO updateMemberDTO) {
		return ResponseEntity.ok(memberService.updateMember(updateMemberDTO));
	}
 }
