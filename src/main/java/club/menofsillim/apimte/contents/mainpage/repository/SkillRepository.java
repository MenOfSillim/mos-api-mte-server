package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> findSkillBySkillNameAndUseYnTrue(String skillName);
    Skill findSkillBySkillName(String skillName);
}
