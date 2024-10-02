package dmplz.family_farm_server.family.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.family.repository.FamilyRepository;
import dmplz.family_farm_server.inviteCode.InviteCodeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyService {

	private final FamilyRepository familyRepository;
	private final InviteCodeService inviteCodeService;

	public Family getFamily(Long id) {
		return familyRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);
	}

	public List<Family> getAllFamily() {
		return familyRepository.findAll();
	}

	public Family getFamilyByInviteCode(String inviteCode) {
		return familyRepository.findByInviteCode(inviteCode)
			.orElseThrow(NoSuchElementException::new);
	}

	public Family createNewFamily() {
		Family family = new Family(inviteCodeService.generateInviteCode());
		familyRepository.save(family);
		return family;
	}

	public Family updateFamily(Family family) {
		familyRepository.findById(family.getFamilyId())
			.orElseThrow(NoSuchElementException::new);
		return familyRepository.save(family);
	}

	public void deleteFamily(Long id) {
		Family findFamily = familyRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);

		familyRepository.delete(findFamily);
	}
}
