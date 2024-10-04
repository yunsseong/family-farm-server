package dmplz.family_farm_server.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dmplz.family_farm_server.member.dto.MemberDTO;
import dmplz.family_farm_server.member.dto.SignUp;
import dmplz.family_farm_server.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signUp")
public class SignUpController {

	private final MemberService memberService;

	@PostMapping
	public ResponseEntity<MemberDTO> signUp (@RequestBody SignUp signUp) {
		return ResponseEntity.ok(new MemberDTO(memberService.createMember(signUp)));
	}
}
