package club.menofsillim.apimte.contents.member.repository;

import club.menofsillim.apimte.contents.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(String name);
}
