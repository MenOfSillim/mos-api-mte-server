package club.menofsillim.apimte.contents.member.service;

import club.menofsillim.apimte.contents.member.domain.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> members();

    Member saveMember(final Member member);
}
