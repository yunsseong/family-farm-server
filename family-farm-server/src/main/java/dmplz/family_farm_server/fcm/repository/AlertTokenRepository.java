package dmplz.family_farm_server.fcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmplz.family_farm_server.fcm.model.AlertToken;

@Repository
public interface AlertTokenRepository extends JpaRepository<AlertToken, Long> {

}
