package dmplz.family_farm_server.fcm.dto;

import dmplz.family_farm_server.member.model.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAlertToken {

	private String deviceId;
	private String tokenValue;
}
