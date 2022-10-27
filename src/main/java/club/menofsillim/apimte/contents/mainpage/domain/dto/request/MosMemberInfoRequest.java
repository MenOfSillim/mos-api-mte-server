package club.menofsillim.apimte.contents.mainpage.domain.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@ApiModel(value = "MOS 멤버 정보")
public class MosMemberInfoRequest {

    @NotNull
    @ApiParam(value = "닉네임", required = true)
    private String nickName;

    @NotNull
    @ApiParam(value = "이메일 주소", required = true)
    private String emailAddress;

    @NotNull
    @ApiParam(value = "성", required = true)
    private String firstName;

    @NotNull
    @ApiParam(value = "이름", required = true)
    private String lastName;

    @NotNull
    @ApiParam(value = "이미지 경로", required = true)
    private String imagePath;

    @NotNull
    @ApiParam(value = "깃허브 주소", required = true)
    private String siteLink;

    @NotNull
    @ApiParam(value = "자기소개", required = true)
    private String introduction;

    @NotNull
    @ApiParam(value = "자기설명", required = true)
    private String description;

    @Builder
    public MosMemberInfoRequest(String nickName, String emailAddress, String firstName, String lastName, String imagePath, String siteLink, String introduction, String description) {
        this.nickName = nickName;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imagePath = imagePath;
        this.siteLink = siteLink;
        this.introduction = introduction;
        this.description = description;
    }
}
