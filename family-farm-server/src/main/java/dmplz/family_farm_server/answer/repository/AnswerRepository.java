package dmplz.family_farm_server.answer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmplz.family_farm_server.answer.model.Answer;
import dmplz.family_farm_server.family.model.Family;
import dmplz.family_farm_server.question.model.FamilyQuestion;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	Optional<List<Answer>> findByFamilyQuestion(FamilyQuestion familyQuestion);
}
