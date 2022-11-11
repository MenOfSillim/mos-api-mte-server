package club.menofsillim.apimte.contents.board.domain.entity;


import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@DiscriminatorValue("NOTICE")
@PrimaryKeyJoinColumn(name = "board_seq")
public class Notice extends Board {

    private boolean noticeYn;
}
