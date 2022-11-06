package club.menofsillim.apimte.contents.mainpage.domain.entity;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosHistoryRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.MosHistoryResponse;
import club.menofsillim.apimte.global.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Table(name = "mos_history")
@NoArgsConstructor
public class MosHistory extends BaseTimeEntity {

    @Id
    @Column(name = "mos_history_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mosHistorySeq;

    @Column(name = "title", nullable = false, length = 40)
    private String title;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "period", nullable = false, length = 6)
    private String period;

    @Column(name = "image_path", length = 200)
    private String imagePath;

    @Column(name = "sort", nullable = false, length = 2)
    private Integer sort;

    @Column(name = "use_yn", nullable = false)
    private boolean uesYn;


    @Builder
    private MosHistory(String title, String description, String period, String imagePath, Integer sort) {
        this.title = title;
        this.description = description;
        this.period = period;
        this.imagePath = imagePath;
        this.sort = sort;
        this.uesYn = true;
    }

    public static MosHistory saveOf(final MosHistoryRequest request) {
        return MosHistory.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .period(request.getPeriod())
                .imagePath(request.getImagePath() == null ? null : request.getImagePath())
                .sort(request.getSort())
                .build();
    }

    public static MosHistoryResponse mosHistoryResponse(final MosHistory mosHistory) {
        return new MosHistoryResponse(mosHistory.getMosHistorySeq(),
                mosHistory.getTitle(),
                mosHistory.getDescription(),
                mosHistory.getPeriod(),
                mosHistory.getImagePath(),
                mosHistory.getSort(),
                mosHistory.isUesYn(),
                mosHistory.getCreatedDate(),
                mosHistory.getModifiedDate());
    }

    public void deleteOf() {
        this.uesYn = false;
    }

    public void useOf() {
        this.uesYn = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MosHistory that = (MosHistory) o;
        return mosHistorySeq != null && Objects.equals(mosHistorySeq, that.mosHistorySeq);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
