package dmplz.family_farm_server.family.dto;

import dmplz.family_farm_server.family.model.Family;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyDTO {

	private Long familyId;
	private String inviteCode;

	public FamilyDTO(Family family) {

		this.familyId = family.getFamilyId();
		this.inviteCode = family.getInviteCode();
	}
}
