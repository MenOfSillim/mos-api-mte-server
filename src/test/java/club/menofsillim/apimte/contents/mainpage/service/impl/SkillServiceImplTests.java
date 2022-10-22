package club.menofsillim.apimte.contents.mainpage.service.impl;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.SkillInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.entity.Skill;
import club.menofsillim.apimte.contents.mainpage.domain.skill.SkillInfoDuplicateException;
import club.menofsillim.apimte.contents.mainpage.repository.SkillRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
class SkillServiceImplTests {

    @Autowired
    private SkillServiceImpl instance;
    @Autowired
    private SkillRepository skillRepository;

    @Test
    void save_newSkill_shouldSuccess() {
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillName("React")
                .skillType("Frontend")
                .build();

        assertNotNull(instance.addToNewSkill(request));
    }

    @Test
    void save_duplicateSkill_shouldFail() {
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillName("Vuejs")
                .skillType("Frontend")
                .build();

        instance.addToNewSkill(request);

        SkillInfoRequest duplicateRequest = SkillInfoRequest.builder()
                .skillName("Vuejs")
                .skillType("Frontend")
                .build();

        assertThrows(SkillInfoDuplicateException.class, () -> {
            instance.addToNewSkill(duplicateRequest);
        });
    }

    @Test
    void save_skillAnd_findSkillname_shouldSuccess() {
        String skillName = "Spring";
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillName(skillName)
                .skillType("Backend")
                .build();

        instance.addToNewSkill(request);

        Skill skill = skillRepository.findSkillBySkillName(skillName);
        Assertions.assertThat(skillName).isEqualTo(skill.getSkillName());
    }

}