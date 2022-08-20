package club.menofsillim.apimte.member;

import club.menofsillim.apimte.member.domain.entity.Member;
import club.menofsillim.apimte.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void saveMember() {
        Member member = Member.builder()
                .name("David")
                .age(33)
                .build();

        final Member saveMember = memberRepository.save(member);

        Assertions.assertThat(member.getName()).isEqualTo(saveMember.getName());
    }
}
