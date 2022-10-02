package club.menofsillim.apimte.contents.mainpage.domain.entity;

import lombok.Getter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Table(name = "mos_member")
public class MosMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSeq;

    @Column(name = "nick_name", nullable = false, length = 40, unique = true)
    private String nickName;

    @Column(name = "email_address", nullable = false, length = 100, unique = true)
    private String emailAddress;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "image_path", nullable = false, length = 100)
    private String imagePath;

    @Column(name = "site_link", nullable = false, length = 100)
    private String siteLink;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @Column(name = "use_yn", nullable = false)
    private boolean useYn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_skill")
    private List<Skill> skills = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MosMember mosMember = (MosMember) o;
        return memberSeq != null && Objects.equals(memberSeq, mosMember.memberSeq);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}