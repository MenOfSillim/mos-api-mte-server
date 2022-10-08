package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MosMemberRepository extends JpaRepository<MosMember, Long> {

    MosMember findMosMemberByNickName(final String nickName);
}
