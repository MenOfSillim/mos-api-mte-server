package club.menofsillim.apimte.contents.mainpage.domain.dto.request;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;


class MosMemberSkillInfoRequestTests {

    String nickName = "Rubok";
    String skillName = "Backend";

    @Test
    void setRequest_notNull_shouldSuccess() {
        MosMemberSkillInfoRequest request = MosMemberSkillInfoRequest.builder()
                .nickName(nickName)
                .skillName(skillName)
                .build();

        Assertions.assertThat(!Objects.isNull(request)).isTrue();
    }

    @Test
    void setRequest_sameNickname_shouldSuccess() {
        MosMemberSkillInfoRequest request = MosMemberSkillInfoRequest.builder()
                .nickName(nickName)
                .skillName(skillName)
                .build();

        Assertions.assertThat(nickName).isEqualTo(request.getNickName());
    }

    @Test
    void setRequest_sameSkillname_shouldSuccess() {
        MosMemberSkillInfoRequest request = MosMemberSkillInfoRequest.builder()
                .nickName(nickName)
                .skillName(skillName)
                .build();

        Assertions.assertThat(skillName).isEqualTo(request.getSkillName());
    }
}