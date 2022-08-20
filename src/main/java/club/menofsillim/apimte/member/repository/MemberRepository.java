package club.menofsillim.apimte.member.repository;

import club.menofsillim.apimte.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByName(String name);
}
