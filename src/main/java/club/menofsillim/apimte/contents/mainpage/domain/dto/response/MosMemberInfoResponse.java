package club.menofsillim.apimte.contents.mainpage.domain.dto.response;

import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MosMemberInfoResponse {

    private String nickName;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String imagePath;
    private String description;

    public MosMemberInfoResponse(final MosMember mosMember) {
        this.nickName = mosMember.getNickName();
        this.emailAddress = mosMember.getEmailAddress();
        this.firstName = mosMember.getFirstName();
        this.lastName = mosMember.getLastName();
        this.imagePath = mosMember.getImagePath();
        this.description = mosMember.getDescription();
    }
}
