package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MosMemberRepository extends JpaRepository<MosMember, Long>, MosMemberRepositoryCustom {

    MosMember findMosMemberByNickNameAndUseYnTrue(final String nickName);
    Optional<MosMember> findMosMemberByMemberSeqAndUseYnTrue(final Long memberSeq);
    List<MosMember> findMosMembersByUseYnTrue();
    Optional<MosMember> findMosMembersByMemberSeqAndUseYnFalse(final Long memberSeq);
}
