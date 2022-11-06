package club.menofsillim.apimte.contents.mainpage.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record MosHistoryResponse(
        @JsonProperty("mosHistorySeq") Long mosHistorySeq,
        @JsonProperty("title") String title,
        @JsonProperty("description") String description,
        @JsonProperty("period") String period,
        @JsonProperty("imagePath") String imagePath,
        @JsonProperty("sort") Integer sort,
        @JsonProperty("useYn") boolean useYn,
        @JsonProperty("createdDate") LocalDateTime createdDate,
        @JsonProperty("updatedDate") LocalDateTime updatedDate
) {

    public MosHistoryResponse(@JsonProperty("mosHistorySeq") Long mosHistorySeq, @JsonProperty("title") String title, @JsonProperty("description") String description, @JsonProperty("period") String period, @JsonProperty("imagePath") String imagePath, @JsonProperty("sort") Integer sort, @JsonProperty("useYn") boolean useYn, @JsonProperty("createdDate") LocalDateTime createdDate, @JsonProperty("updatedDate") LocalDateTime updatedDate) {
        this.mosHistorySeq = mosHistorySeq;
        this.title = title;
        this.description = description;
        this.period = period;
        this.imagePath = imagePath;
        this.sort = sort;
        this.useYn = useYn;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

}
