package club.menofsillim.apimte.contents.member.domain.dto;

import club.menofsillim.apimte.contents.member.domain.entity.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@ApiModel(value = "회원정보")
public class MemberDTO {

    @NotBlank(message = "NAME_IS_MANDATORY")
    @ApiModelProperty(value = "이름")
    private String name;

    @NotNull(message = "AGE_IS_MANDATORY")
    @ApiModelProperty(value = "나이")
    private Integer age;

    @Builder
    public MemberDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .age(age)
                .build();
    }
}
