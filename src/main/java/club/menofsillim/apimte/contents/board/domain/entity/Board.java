package club.menofsillim.apimte.contents.board.domain.entity;

import club.menofsillim.apimte.global.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;
    private String title;
    private String content;
    private String writer;
    private Long count;
    private boolean exposure;

    public void plusCount() {
        this.count += 1;
    }

    @Builder
    public Board(String title, String content, String writer, Long count, boolean exposure) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.count = count;
        this.exposure = exposure;
    }
}
