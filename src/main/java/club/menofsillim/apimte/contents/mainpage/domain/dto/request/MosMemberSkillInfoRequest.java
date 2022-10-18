package club.menofsillim.apimte.contents.mainpage.domain.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@ApiModel(value = "MOS 멤버와 스킬 정보")
public class MosMemberSkillInfoRequest {

    @ApiParam(value = "닉네임", required = true)
    private String nickName;

    @ApiParam(value = "기술 명", required = true)
    private String skillName;

    @Builder
    public MosMemberSkillInfoRequest(String nickName, String skillName) {
        this.nickName = nickName;
        this.skillName = skillName;
    }
}