package club.menofsillim.apimte.contents.mainpage.domain.entity;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberInfoRequest;
import club.menofsillim.apimte.global.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Table(name = "mos_member")
@NoArgsConstructor
public class MosMember extends BaseTimeEntity {

    @Id
    @Column(name = "member_seq")
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

    @Column(name = "avatar_path", nullable = false, length = 100)
    private String avatarPath;

    @Column(name = "profile_path", length = 100)
    private String profilePath;

    @Column(name = "site_link", nullable = false, length = 100)
    private String siteLink;

    @Column(name = "introduction", nullable = false, length = 50)
    private String introduction;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "use_yn", nullable = false)
    private boolean useYn;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_skill", joinColumns = @JoinColumn(name = "mos_members_member_seq"),
            inverseJoinColumns = @JoinColumn(name = "skills_skill_seq"))
    private List<Skill> skills = new ArrayList<>();

    @Builder
    private MosMember(String nickName, String emailAddress, String firstName, String lastName, String avatarPath, String profilePath, String siteLink, String introduction, String description) {
        this.nickName = nickName;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatarPath = avatarPath;
        this.profilePath = profilePath;
        this.siteLink = siteLink;
        this.introduction = introduction;
        this.description = description;
        this.useYn = true;
    }

    public static MosMember saveOf(final MosMemberInfoRequest request) {
        return MosMember.builder()
                .nickName(request.getNickName())
                .emailAddress(request.getEmailAddress())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .avatarPath(request.getAvatarPath())
                .profilePath(request.getProfilePath())
                .siteLink(request.getSiteLink())
                .introduction(request.getIntroduction())
                .description(request.getDescription())
                .build();
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
        MosMember mosMember = (MosMember) o;
        return memberSeq != null && Objects.equals(memberSeq, mosMember.memberSeq);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}