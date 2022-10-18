package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;

public interface MosMemberRepositoryCustom {

    MosMember findCustomMosMemberByNickname(final String nickName);
}