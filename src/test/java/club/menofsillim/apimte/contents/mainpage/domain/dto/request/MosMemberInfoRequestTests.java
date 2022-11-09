package club.menofsillim.apimte.contents.mainpage.domain.dto.request;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class MosMemberInfoRequestTests {

    String nickName = "Rubok";
    String emailAddress = "truspring1@gmail.com";
    String firstName = "Seok";
    String lastName = "gyuhwan";
    String avatarPath = "images/avatar/rubok";
    String profilePath = "images/profile/rubok";
    String siteLink = "https://github.com/truespring";
    String introduction = "I'm Rubok!!!";
    String description = "I'm Backend Developer. I work in Fassto. Fassto is Fullfillment Service provider Company.";

    @Test
    void setRequest_sameNickname_shouldSuccess() {
        MosMemberInfoRequest request = MosMemberInfoRequest
                .builder()
                .nickName(nickName)
                .emailAddress(emailAddress)
                .firstName(firstName)
                .lastName(lastName)
                .avatarPath(avatarPath)
                .profilePath(profilePath)
                .siteLink(siteLink)
                .introduction(introduction)
                .description(description)
                .build();

        assertThat(request.getNickName()).isEqualTo(nickName);
    }

    @Test
    void setRequest_notNull_shouldSuccess() {
        MosMemberInfoRequest request = MosMemberInfoRequest
                .builder()
                .nickName(nickName)
                .emailAddress(emailAddress)
                .firstName(firstName)
                .lastName(lastName)
                .avatarPath(avatarPath)
                .profilePath(profilePath)
                .siteLink(siteLink)
                .introduction(introduction)
                .description(description)
                .build();

        assertThat(!Objects.isNull(request)).isTrue();
    }
}