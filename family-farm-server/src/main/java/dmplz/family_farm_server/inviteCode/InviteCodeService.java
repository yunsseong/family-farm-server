package dmplz.family_farm_server.inviteCode;

import java.util.Random;

import org.springframework.stereotype.Service;

import dmplz.family_farm_server.family.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InviteCodeService {

	private final static String codeStringPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private final FamilyRepository familyRepository;
	private final Random random = new Random();

	public String generateInviteCode() {
		String inviteCode = "";
		do {
			inviteCode = generateCode(6);
		} while (isUniqueInviteCode(inviteCode));
		return inviteCode;
	}

	public String generateCode(int length) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < length; i++) {
			int index = random.nextInt(codeStringPool.length());
			stringBuilder.append(codeStringPool.charAt(index));
		}
		return stringBuilder.toString();
	}

	public boolean isUniqueInviteCode(String inviteCode) {
		try {
			familyRepository.findByInviteCode(inviteCode);
		} catch (Exception e) {
			return true;
		}
		return false;
	}
}
