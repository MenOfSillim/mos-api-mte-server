package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.SkillInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.entity.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class SkillRepositoryTests {

    @Autowired
    private SkillRepository repository;

    @Test
    void save_notExist_shouldReturnResult() {
        String skillName = "Spring";
        String skillType = "Backend";
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillName(skillName)
                .skillType(skillType)
                .build();

        Skill skill = Skill.of(request);

        repository.save(skill);

        Skill found = repository.findSkillBySkillNameAndUseYnTrue(skillName).orElseThrow();
        assertThat(skillName).isEqualTo(found.getSkillName());
    }

    @Test
    void save_nullSkillnameSkill_shouldBeFail() {
        String skillType = "Backend";
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillName(null)
                .skillType(skillType)
                .build();

        Skill skill = Skill.of(request);

        assertThrows(DataIntegrityViolationException.class, () -> {
            repository.save(skill);
        });
    }
}