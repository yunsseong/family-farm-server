package dmplz.family_farm_server.fcm.dto;

import java.util.List;

import dmplz.family_farm_server.fcm.model.AlertToken;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlertTokenDTO {

	private Long alertTokenId;
	private Long memberId;
	private String deviceId;
	private String tokenValue;

	public AlertTokenDTO(AlertToken alertToken) {
		this.alertTokenId = alertToken.getId();
		this.memberId = alertToken.getMember().getMemberId();
		this.deviceId = alertToken.getDeviceId();
		this.tokenValue = alertToken.getTokenValue();
	}
}
