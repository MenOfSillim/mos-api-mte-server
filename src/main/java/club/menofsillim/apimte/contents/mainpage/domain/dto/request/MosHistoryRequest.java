package club.menofsillim.apimte.contents.mainpage.domain.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@ApiModel(value = "MOS 역사 정보")
public class MosHistoryRequest {

    @NotNull
    @ApiParam(value = "제목", required = true)
    private String title;

    @NotNull @ApiParam(value = "설명", required = true)
    private String description;

    @NotNull @ApiParam(value = "기간", required = true, example = "yyyyMM")
    private String period;

    @ApiParam(value = "이미지 경로")
    private String imagePath;

    @NotNull @ApiParam(value = "순서", required = true, example = "1")
    private Integer sort;

    @Builder
    public MosHistoryRequest(String title, String description, String period, String imagePath, Integer sort) {
        this.title = title;
        this.description = description;
        this.period = period;
        this.imagePath = imagePath;
        this.sort = sort;
    }
}
