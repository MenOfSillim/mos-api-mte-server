package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

import static club.menofsillim.apimte.contents.mainpage.domain.entity.QMosMember.mosMember;

public class MosMemberRepositoryCustomImpl implements MosMemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MosMemberRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public MosMember findCustomMosMemberByNickname(String nickName) {

        MosMember member = queryFactory
                .selectFrom(mosMember)
                .where(mosMember.nickName.eq(nickName))
                .fetchOne();

/*
* select mm.*, ms.* from mos_member mm inner join member_skill ms on mm.member_seq = ms.member_seq where nick_name = ?
* select mm.nick_name, ms.skill_seq from mos_member mm inner join member_skill ms on mm.member_seq = ms.member_seq where nick_name = ?
* */

        return member;
    }
}
