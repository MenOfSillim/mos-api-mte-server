package club.menofsillim.apimte.member.service;

import club.menofsillim.apimte.member.domain.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> members();

    Member saveMember(final Member member);
}
