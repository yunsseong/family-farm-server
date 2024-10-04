package dmplz.family_farm_server.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberDTO {
	private Long memberId;
	private String nickname;
}
