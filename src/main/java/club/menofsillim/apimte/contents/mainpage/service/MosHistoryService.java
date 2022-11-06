package club.menofsillim.apimte.contents.mainpage.service;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosHistoryRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.MosHistoryResponse;

import java.util.List;

public interface MosHistoryService {
    MosHistoryResponse addNewMosHistory(final MosHistoryRequest request);
    List<MosHistoryResponse> findAllMosHistory();
}
