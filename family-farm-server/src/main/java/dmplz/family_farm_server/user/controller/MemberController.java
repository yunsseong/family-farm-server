package dmplz.family_farm_server.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dmplz.family_farm_server.user.DTO.SignUp;
import dmplz.family_farm_server.user.model.Member;
import dmplz.family_farm_server.user.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign-up")
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public ResponseEntity<Member> signUp (SignUp signUp) {
		return ResponseEntity.ok(memberService.createMember(signUp));
	}
}
