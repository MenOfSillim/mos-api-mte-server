package club.menofsillim.apimte.contents.mainpage.service.impl;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import club.menofsillim.apimte.contents.mainpage.domain.mosmember.MosMemberNotFoundExcpetion;
import club.menofsillim.apimte.contents.mainpage.repository.MosMemberRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
class MosMemberServiceImplTests {

    @Autowired
    private MosMemberServiceImpl instance;
    @Autowired
    private MosMemberRepository mosMemberRepositoryMock;

    @Test
    @Order(1)
    void loadAllMosMember_shouldFail() {
        Exception exception = null;
        try {
            instance.findAllMosMember();
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof MosMemberNotFoundExcpetion);
    }

    @Test
    @Order(2)
    void loadMosMemberByNickname_existNickname_shouldSucceed() {
        String nickName = "rubok";
        MosMemberInfoRequest request = MosMemberInfoRequest.builder()
                .nickName(nickName)
                .siteLink("https://github.com/truespring")
                .firstName("seok")
                .lastName("gyuhwan")
                .emailAddress("truespring1@gmail.com")
                .avatarPath("path/path")
                .profilePath("images/profile/rubok")
                .introduction("I'm Rubok!!")
                .description("I'm Backend Developer. I work in Fassto. Fassto is Fullfillment Service provider Company.")
                .build();

        instance.addToNewMosMember(request);
        MosMember mosMember = mosMemberRepositoryMock.findMosMemberByNickNameAndUseYnTrue(nickName);

        assertNotNull(mosMember);
        assertEquals(nickName, mosMember.getNickName());
    }
}