package dmplz.family_farm_server.family.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dmplz.family_farm_server.family.model.Family;

public interface FamilyRepository extends JpaRepository<Family, Long> {
	Optional<Family> findByInviteCode(String inviteCode);
}
