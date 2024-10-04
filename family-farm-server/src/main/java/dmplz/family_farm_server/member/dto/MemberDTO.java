package dmplz.family_farm_server.member.dto;

import dmplz.family_farm_server.family.dto.FamilyDTO;
import dmplz.family_farm_server.member.model.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

	private Long id;
	private String nickname;
	private FamilyDTO family;

	public MemberDTO(Member member) {
		this.id = member.getMemberId();
		this.nickname = member.getNickname();
		this.family = new FamilyDTO(member.getFamily());
	}
}
