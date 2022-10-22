package club.menofsillim.apimte.contents.mainpage.domain.dto.request;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class SkillInfoRequestTests {

    String skillName = "Spring";
    String skillType = "백엔드";

    @Test
    void setRequest_notNull_shouldSuccess() {
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillName(skillName)
                .skillType(skillType)
                .build();

        Assertions.assertThat(!Objects.isNull(request)).isTrue();
    }

    @Test
    void setRequest_sameSkillname_shouldSuccess() {
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillName(skillName)
                .skillType(skillType)
                .build();

        Assertions.assertThat(skillName).isEqualTo(request.getSkillName());
    }


    @Test
    void setRequest_sameSkillType_shouldSuccess() {
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillType(skillType)
                .skillName(skillName)
                .build();

        Assertions.assertThat(skillType).isEqualTo(skillType);
    }
}