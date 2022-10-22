package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.request.SkillInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import club.menofsillim.apimte.contents.mainpage.domain.entity.Skill;
import club.menofsillim.apimte.contents.mainpage.domain.mosmember.MosMemberNotFoundExcpetion;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import java.util.NoSuchElementException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@ActiveProfiles("test")
class MosMemberRepositoryTests {

    @Autowired
    private MosMemberRepository mosMemberRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Test
    void save_nullNickname_shouldFail() {
        String nickName = null;
        MosMemberInfoRequest request = MosMemberInfoRequest.builder()
                .nickName(nickName)
                .siteLink("https://github.com/truespring")
                .firstName("seok")
                .lastName("gyuhwan")
                .emailAddress("truespring1@gmail.com")
                .imagePath("path/path")
                .description("I'm Rubok!!")
                .build();

        MosMember member = MosMember.of(request);

        assertThrows(DataIntegrityViolationException.class, () -> {
            mosMemberRepository.save(member);
        });
    }

    @Test
    void findByNickName_exist_shouldReturnResult() {
        String nickName = "rubok";
        MosMemberInfoRequest request = MosMemberInfoRequest.builder()
                .nickName(nickName)
                .siteLink("https://github.com/truespring")
                .firstName("seok")
                .lastName("gyuhwan")
                .emailAddress("truespring1@gmail.com")
                .imagePath("path/path")
                .introduction("I'm Rubok!!")
                .description("I'm Backend Developer. I work in Fassto. Fassto is Fullfillment Service provider Company.")
                .build();

        MosMember member1 = MosMember.of(request);

        mosMemberRepository.save(member1);

        MosMember found = mosMemberRepository.findMosMemberByNickNameAndUseYnTrue(nickName);
        assertThat(nickName).isEqualTo(found.getNickName());
    }

    @Test
    void save_mosmember_skill_shouldReturnResult() {
        String nickName = "Rubok";

        MosMemberInfoRequest request = MosMemberInfoRequest.builder()
                .nickName(nickName)
                .siteLink("https://github.com/truespring")
                .firstName("seok")
                .lastName("gyuhwan")
                .emailAddress("truespring1@gmail.com")
                .imagePath("path/path")
                .introduction("I'm Rubok!!")
                .description("I'm Backend Developer. I work in Fassto. Fassto is Fullfillment Service provider Company.")
                .build();

        MosMember member = MosMember.of(request);

        mosMemberRepository.save(member);

        SkillInfoRequest skillInfoRequest = SkillInfoRequest.builder()
                .skillName("Spring")
                .skillType("Backend")
                .build();

        Skill skill = Skill.of(skillInfoRequest);

        skillRepository.save(skill);

        member.getSkills().add(skill);
    }

    @Test
    void findMosmember_useYnFalse_shouldFail() {
        String nickName = "Rubok";

        MosMemberInfoRequest request = MosMemberInfoRequest.builder()
                .nickName(nickName)
                .siteLink("https://github.com/truespring")
                .firstName("seok")
                .lastName("gyuhwan")
                .emailAddress("truespring1@gmail.com")
                .imagePath("path/path")
                .introduction("I'm Rubok!!")
                .description("I'm Backend Developer. I work in Fassto. Fassto is Fullfillment Service provider Company.")
                .build();

        MosMember member = MosMember.of(request);

        mosMemberRepository.save(member);

        member.deleteOf();

        assertThrows(NoSuchElementException.class, () -> {

            MosMember result = mosMemberRepository.findMosMemberByMemberSeqAndUseYnTrue(member.getMemberSeq()).orElseThrow();
        });
    }

    @Test
    void findMosmember_useYnFalse_shouldSuccess() {
        String nickName = "Rubok";

        MosMemberInfoRequest request = MosMemberInfoRequest.builder()
                .nickName(nickName)
                .siteLink("https://github.com/truespring")
                .firstName("seok")
                .lastName("gyuhwan")
                .emailAddress("truespring1@gmail.com")
                .imagePath("path/path")
                .introduction("I'm Rubok!!")
                .description("I'm Backend Developer. I work in Fassto. Fassto is Fullfillment Service provider Company.")
                .build();

        MosMember member = MosMember.of(request);

        mosMemberRepository.save(member);

        member.deleteOf();

        MosMember result = mosMemberRepository.findMosMemberByMemberSeqAndUseYnFalse(member.getMemberSeq()).orElseThrow(MosMemberNotFoundExcpetion::new);
        Assertions.assertThat(Objects.isNull(result)).isFalse();
    }

    @Test
    void findMosmember_useYnTrue_shouldFail() {
        String nickName = "Rubok";

        MosMemberInfoRequest request = MosMemberInfoRequest.builder()
                .nickName(nickName)
                .siteLink("https://github.com/truespring")
                .firstName("seok")
                .lastName("gyuhwan")
                .emailAddress("truespring1@gmail.com")
                .imagePath("path/path")
                .introduction("I'm Rubok!!")
                .description("I'm Backend Developer. I work in Fassto. Fassto is Fullfillment Service provider Company.")
                .build();

        MosMember member = MosMember.of(request);

        mosMemberRepository.save(member);

        assertThrows(NoSuchElementException.class, () -> {
            MosMember result = mosMemberRepository.findMosMemberByMemberSeqAndUseYnFalse(member.getMemberSeq()).orElseThrow();
        });
    }

    @Test
    void findMosmember_useYnTrue_shouldSuccess() {
        String nickName = "Rubok";

        MosMemberInfoRequest request = MosMemberInfoRequest.builder()
                .nickName(nickName)
                .siteLink("https://github.com/truespring")
                .firstName("seok")
                .lastName("gyuhwan")
                .emailAddress("truespring1@gmail.com")
                .imagePath("path/path")
                .introduction("I'm Rubok!!")
                .description("I'm Backend Developer. I work in Fassto. Fassto is Fullfillment Service provider Company.")
                .build();

        MosMember member = MosMember.of(request);

        mosMemberRepository.save(member);

        MosMember result = mosMemberRepository.findMosMemberByMemberSeqAndUseYnTrue(member.getMemberSeq()).orElseThrow(MosMemberNotFoundExcpetion::new);

        Assertions.assertThat(Objects.isNull(result)).isFalse();
    }

}