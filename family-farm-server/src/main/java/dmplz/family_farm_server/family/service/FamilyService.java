package dmplz.family_farm_server.family.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.family.repository.FamilyRepository;
import dmplz.family_farm_server.inviteCode.InviteCodeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyService {

	private final FamilyRepository familyRepository;
	private final InviteCodeService inviteCodeService;

	@Transactional(readOnly = true)
	public Family getFamily(Long id) {
		return familyRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);
	}

	@Transactional(readOnly = true)
	public List<Family> getAllFamily() {
		return familyRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Family getFamilyByInviteCode(String inviteCode) {
		return familyRepository.findByInviteCode(inviteCode)
			.orElseThrow(NoSuchElementException::new);
	}

	@Transactional
	public Family createNewFamily() {
		return familyRepository.save(new Family(inviteCodeService.generateInviteCode()));
	}

	@Transactional
	public Family updateFamily(Family family) {
		familyRepository.findById(family.getFamilyId())
			.orElseThrow(NoSuchElementException::new);
		return familyRepository.save(family);
	}

	@Transactional
	public void deleteFamily(Long id) {
		Family findFamily = familyRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);

		familyRepository.delete(findFamily);
	}
}
