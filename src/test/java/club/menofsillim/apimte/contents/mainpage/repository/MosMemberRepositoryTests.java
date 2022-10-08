package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class MosMemberRepositoryTests {

    @Autowired
    private MosMemberRepository repository;

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
                .description("I'm Rubok!!")
                .build();

        MosMember member1 = MosMember.of(request);

        repository.save(member1);

        MosMember found = repository.findMosMemberByNickName(nickName);
        assertThat(nickName).isEqualTo(found.getNickName());
    }
}