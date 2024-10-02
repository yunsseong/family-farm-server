package dmplz.family_farm_server.user.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUp {

	private String nickname;
	private String inviteCode;

	public SignUp(String nickname, String inviteCode) {
		this.nickname = nickname;
		this.inviteCode = inviteCode;
	}

	public SignUp(String nickname) {
		this.nickname = nickname;
	}
}
