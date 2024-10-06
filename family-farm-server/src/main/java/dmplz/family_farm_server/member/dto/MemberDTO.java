package dmplz.family_farm_server.member.dto;

import java.util.List;

import dmplz.family_farm_server.family.dto.FamilyDTO;
import dmplz.family_farm_server.fcm.dto.AlertTokenDTO;
import dmplz.family_farm_server.member.model.BirthType;
import dmplz.family_farm_server.member.model.FamilyRole;
import dmplz.family_farm_server.member.model.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

	private Long id;
	private String nickname;
	private FamilyDTO family;
	private BirthType birthType;
	private FamilyRole familyRole;
	private AlertTokenDTO alertTokenDTO;

	public MemberDTO(Member member) {
		this.id = member.getMemberId();
		this.nickname = member.getNickname();
		this.family = new FamilyDTO(member.getFamily());
		this.birthType = member.getBirthType();
		this.familyRole = member.getFamilyRole();
		this.alertTokenDTO = new AlertTokenDTO(member.getAlertToken());
	}
}
