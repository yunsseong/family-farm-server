package dmplz.family_farm_server.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmplz.family_farm_server.member.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
