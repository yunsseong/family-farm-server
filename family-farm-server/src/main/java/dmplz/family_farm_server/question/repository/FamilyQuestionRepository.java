package dmplz.family_farm_server.question.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.question.model.FamilyQuestion;
import dmplz.family_farm_server.question.model.Question;

@Repository
public interface FamilyQuestionRepository extends JpaRepository<FamilyQuestion, Long> {
	Optional<List<FamilyQuestion>> findByFamily(Family family);

	Optional<List<FamilyQuestion>> findAllByFamily(Family family);
	Optional<FamilyQuestion> findByFamilyAndQuestion(Family family, Question Question);
}
