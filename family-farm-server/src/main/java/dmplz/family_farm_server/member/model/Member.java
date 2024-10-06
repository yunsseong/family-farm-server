package dmplz.family_farm_server.member.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.fcm.model.AlertToken;
import dmplz.family_farm_server.member.dto.SignUp;
import dmplz.family_farm_server.member.dto.UpdateMemberDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;

	private String nickname;

	private LocalDateTime birthday;

	private BirthType birthType;

	private FamilyRole familyRole;

	@OneToOne
	private AlertToken alertToken;

	@ManyToOne
	@JoinColumn(name = "family_id")
	private Family family;

	public Member(SignUp signUp) {
		this.nickname = signUp.getNickname();
		this.birthday = signUp.getBirthday();
		this.birthType = signUp.getBirthType();
		this.familyRole = signUp.getFamilyRole();
	}

	public void allocateFamily(Family family) {
		this.family = family;
		family.addMember(this);
	}

	public void connectAlertToken(AlertToken alertToken) {
		this.alertToken = alertToken;
		alertToken.connectMember(this);
	}

	public Member update(UpdateMemberDTO updateMemberDTO) {
		this.nickname = updateMemberDTO.getNickname();
		return this;
	}
}
