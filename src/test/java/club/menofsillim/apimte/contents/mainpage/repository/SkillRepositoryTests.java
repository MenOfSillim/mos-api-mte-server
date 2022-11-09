package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.SkillInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.entity.Skill;
import club.menofsillim.apimte.global.common.enums.SkillType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@ActiveProfiles("test")
class SkillRepositoryTests {

    @Autowired
    private SkillRepository repository;

    @Test
    void save_notExist_shouldReturnResult() {
        String skillName = "Spring";
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillName(skillName)
                .skillType(SkillType.BACKEND)
                .build();

        Skill skill = Skill.saveOf(request);

        repository.save(skill);

        Skill found = repository.findSkillBySkillNameAndUseYnTrue(skillName).orElseThrow();
        assertThat(skillName).isEqualTo(found.getSkillName());
    }

    @Test
    void save_nullSkillnameSkill_shouldBeFail() {
        SkillInfoRequest request = SkillInfoRequest.builder()
                .skillName(null)
                .skillType(SkillType.BACKEND)
                .build();

        Skill skill = Skill.saveOf(request);

        assertThrows(DataIntegrityViolationException.class, () -> {
            repository.save(skill);
        });
    }
}