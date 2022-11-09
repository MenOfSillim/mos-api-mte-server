package club.menofsillim.apimte.contents.mainpage.repository;

import club.menofsillim.apimte.contents.mainpage.domain.entity.MosHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MosHistoryRepository extends JpaRepository<MosHistory, Long> {
}
