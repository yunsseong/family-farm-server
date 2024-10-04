package dmplz.family_farm_server.member.model;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.member.dto.UpdateMemberDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "family_id")
	private Family family;

	public Member(String nickname) {
		this.nickname = nickname;
	}

	public void allocateFamily(Family family) {
		this.family = family;
		family.addMember(this);
	}

	@Override
	public String toString() {
		return "Member{" +
			"memberId=" + memberId +
			", nickname='" + nickname + '\'' +
			", family=" + family +
			'}';
	}

	public Member update(UpdateMemberDTO updateMemberDTO) {
		this.nickname = updateMemberDTO.getNickname();
		return this;
	}
}
