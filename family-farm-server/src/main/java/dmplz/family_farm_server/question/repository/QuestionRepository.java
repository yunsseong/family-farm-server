package dmplz.family_farm_server.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmplz.family_farm_server.question.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
