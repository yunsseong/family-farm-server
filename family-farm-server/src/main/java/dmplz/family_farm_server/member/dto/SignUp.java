package dmplz.family_farm_server.member.dto;

import java.time.LocalDateTime;

import dmplz.family_farm_server.fcm.dto.AlertTokenDTO;
import dmplz.family_farm_server.fcm.dto.RegisterAlertToken;
import dmplz.family_farm_server.fcm.model.AlertToken;
import dmplz.family_farm_server.member.model.BirthType;
import dmplz.family_farm_server.member.model.FamilyRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUp {

	private String nickname;
	private String inviteCode;
	private LocalDateTime birthday;
	private BirthType birthType;
	private FamilyRole familyRole;
	private RegisterAlertToken registerAlertToken;

	public SignUp(String nickname, String inviteCode, LocalDateTime birthday, BirthType birthType, FamilyRole familyRole, RegisterAlertToken registerAlertToken) {
		this.nickname = nickname;
		this.inviteCode = inviteCode;
		this.birthday = birthday;
		this.birthType = birthType;
		this.familyRole = familyRole;
		this.registerAlertToken = registerAlertToken;
	}

	public SignUp(String nickname) {
		this.nickname = nickname;
	}
}
