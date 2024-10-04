package dmplz.family_farm_server.family.model;

import java.util.ArrayList;
import java.util.List;

import dmplz.family_farm_server.member.model.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Family {

	@Id
	@Column(name = "family_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long familyId;

	@OneToMany(mappedBy = "family", fetch = FetchType.LAZY)
	@Column(name = "member_id")
	private List<Member> members;

	@Column(name = "invite_code")
	private String inviteCode;

	public Family(String inviteCode) {
		this.inviteCode = inviteCode;
		this.members = new ArrayList<>();
	}

	public void addMember(Member member) {
		members.add(member);
	}

	@Override
	public String toString() {
		return "Family{" +
			"familyId=" + familyId +
			", inviteCode='" + inviteCode + '\'' +
			'}';
	}
}
