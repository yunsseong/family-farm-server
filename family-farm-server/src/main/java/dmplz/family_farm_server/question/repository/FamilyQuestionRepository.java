package dmplz.family_farm_server.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.question.model.FamilyQuestion;

@Repository
public interface FamilyQuestionRepository extends JpaRepository<FamilyQuestion, Long> {
	List<FamilyQuestion> findByFamily(Family family);

	List<FamilyQuestion> findAllByFamily(Family family);
}
