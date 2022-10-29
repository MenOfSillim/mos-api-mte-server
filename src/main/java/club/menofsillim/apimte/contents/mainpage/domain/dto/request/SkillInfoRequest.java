package club.menofsillim.apimte.contents.mainpage.domain.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@ApiModel(value = "기술 정보")
public class SkillInfoRequest {

    @NotNull
    @ApiParam(value = "기술 명", required = true)
    private String skillName;

    @NotNull
    @ApiParam(value = "기술 분류", required = true)
    private String skillType;

    @Builder
    public SkillInfoRequest(String skillName, String skillType) {
        this.skillName = skillName;
        this.skillType = skillType;
    }
}
