package club.menofsillim.apimte.contents.mainpage.domain.entity;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.SkillInfoRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Table(name = "skill")
@NoArgsConstructor
public class Skill {

    @Id
    @Column(name = "skill_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillSeq;

    @Column(name = "skill_name", nullable = false, unique = true, length = 15)
    private String skillName;

    @Column(name = "skill_type", nullable = false, length = 20)
    private String skillType;

    @Column(name = "use_yn", nullable = false)
    private boolean useYn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    private Skill(String skillName, String skillType) {
        this.skillName = skillName;
        this.skillType = skillType;
        this.useYn = true;
        this.createdDate = new Date();
    }

    public static Skill of(final SkillInfoRequest request) {
        return new Skill(request.getSkillName(), request.getSkillType());
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