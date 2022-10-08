package club.menofsillim.apimte.contents.mainpage.domain.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.*;

@Getter
@ToString
@ApiModel(value = "MOS 멤버 정보")
public class MosMemberInfoRequest {

    @ApiParam(value = "닉네임", required = true)
    private String nickName;
    @ApiParam(value = "이메일 주소", required = true)
    private String emailAddress;
    @ApiParam(value = "성", required = true)
    private String firstName;
    @ApiParam(value = "이름", required = true)
    private String lastName;
    @ApiParam(value = "이미지 경로", required = true)
    private String imagePath;
    @ApiParam(value = "깃허브 주소", required = true)
    private String siteLink;
    @ApiParam(value = "자기소개", required = true)
    private String description;

    @Builder
    public MosMemberInfoRequest(String nickName, String emailAddress, String firstName, String lastName, String imagePath, String siteLink, String description) {
        this.nickName = nickName;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imagePath = imagePath;
        this.siteLink = siteLink;
        this.description = description;
    }
}
