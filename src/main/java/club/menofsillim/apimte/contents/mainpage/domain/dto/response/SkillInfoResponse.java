package club.menofsillim.apimte.contents.mainpage.domain.dto.response;

import club.menofsillim.apimte.contents.mainpage.domain.entity.Skill;
import lombok.ToString;

@ToString
public class SkillInfoResponse {
    private Long skillSeq;
    private String skillName;
    private String skillType;

    public SkillInfoResponse(final Skill skill) {
        this.skillSeq = skill.getSkillSeq();
        this.skillName = skill.getSkillName();
        this.skillType = skill.getSkillType();
    }
}
