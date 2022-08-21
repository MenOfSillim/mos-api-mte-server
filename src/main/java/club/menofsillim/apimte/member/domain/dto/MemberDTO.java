package club.menofsillim.apimte.member.domain.dto;

import club.menofsillim.apimte.member.domain.entity.Member;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class MemberDTO {

    @NotBlank(message = "NAME_IS_MANDATORY")
    private String name;
    @NotNull(message = "AGE_IS_MANDATORY")
    private Integer age;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .age(age)
                .build();
    }
}
