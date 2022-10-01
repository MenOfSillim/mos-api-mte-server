package club.menofsillim.apimte.contents.member.controller;

import club.menofsillim.apimte.contents.member.domain.entity.Member;
import club.menofsillim.apimte.contents.member.repository.MemberRepository;
import club.menofsillim.apimte.contents.member.service.MemberService;
import club.menofsillim.apimte.contents.member.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class MemberControllerTest {

    @Autowired
    private MemberRepository memberRepository;
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService = new MemberServiceImpl(memberRepository);
    }

    @Test
    void saveMemberFindByName() {
        Member member = Member.builder()
                .name("David")
                .age(33)
                .build();

        final Member saveMember = memberService.saveMember(member);

        Assertions.assertThat(member.getName()).isEqualTo(saveMember.getName());
    }
}