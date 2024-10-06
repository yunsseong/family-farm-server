package dmplz.family_farm_server.fcm.model;

import dmplz.family_farm_server.fcm.dto.RegisterAlertToken;
import dmplz.family_farm_server.member.model.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class AlertToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Member member;

	private String deviceId;

	private String tokenValue;

	public AlertToken(RegisterAlertToken registerAlertToken) {
		this.deviceId = registerAlertToken.getDeviceId();
		this.tokenValue = registerAlertToken.getTokenValue();
	}

	public void connectMember(Member member) {
		this.member = member;
	}
}
