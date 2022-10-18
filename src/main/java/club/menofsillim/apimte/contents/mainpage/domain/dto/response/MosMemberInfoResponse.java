package club.menofsillim.apimte.contents.mainpage.domain.dto.response;

import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import club.menofsillim.apimte.contents.mainpage.domain.entity.Skill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class MosMemberInfoResponse {

    private Long memberSeq;
    private String nickName;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String imagePath;
    private String introduction;
    private String description;
    private List<Skill> skills;

    public MosMemberInfoResponse(final MosMember mosMember) {
        this.memberSeq = mosMember.getMemberSeq();
        this.nickName = mosMember.getNickName();
        this.emailAddress = mosMember.getEmailAddress();
        this.firstName = mosMember.getFirstName();
        this.lastName = mosMember.getLastName();
        this.imagePath = mosMember.getImagePath();
        this.introduction = mosMember.getIntroduction();
        this.description = mosMember.getDescription();
        this.skills = mosMember.getSkills().stream().toList();
    }
}
