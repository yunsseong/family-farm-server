package dmplz.family_farm_server.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmplz.family_farm_server.user.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
