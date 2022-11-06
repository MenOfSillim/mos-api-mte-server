package club.menofsillim.apimte.contents.mainpage.domain.entity;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.SkillInfoRequest;
import club.menofsillim.apimte.global.BaseTimeEntity;
import club.menofsillim.apimte.global.common.enums.SkillType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Table(name = "skill")
@NoArgsConstructor
public class Skill extends BaseTimeEntity {

    @Id
    @Column(name = "skill_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillSeq;

    @Column(name = "skill_name", nullable = false, unique = true, length = 15)
    private String skillName;

    @Column(name = "skill_type", nullable = false, length = 20)
    private SkillType skillType;

    @Column(name = "use_yn", nullable = false)
    private boolean useYn;

    private Skill(String skillName, SkillType skillType) {
        this.skillName = skillName;
        this.skillType = skillType;
        this.useYn = true;
    }

    public static Skill saveOf(final SkillInfoRequest request) {
        return new Skill(request.getSkillName(), request.getSkillType());
    }

    public void deleteOf() {
        this.useYn = false;
    }

    public void useOf() {
        this.useYn = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Skill skill = (Skill) o;
        return skillSeq != null && Objects.equals(skillSeq, skill.skillSeq);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}