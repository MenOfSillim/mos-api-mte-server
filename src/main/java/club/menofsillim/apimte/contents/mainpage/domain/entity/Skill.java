package club.menofsillim.apimte.contents.mainpage.domain.entity;

import club.menofsillim.apimte.contents.mainpage.domain.type.SkillType;
import lombok.Getter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillSeq;

    @Column(name = "skill_name", nullable = false, unique = true, length = 15)
    private String skillName;

    @Column(name = "skill_type", nullable = false, unique = true, length = 20)
    private SkillType skillType;

    @ManyToMany(mappedBy = "skills")
    private List<MosMember> mosMembers = new ArrayList<>();

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