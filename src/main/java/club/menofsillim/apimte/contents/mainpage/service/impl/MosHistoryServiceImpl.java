package club.menofsillim.apimte.contents.mainpage.service.impl;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosHistoryRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.MosHistoryResponse;
import club.menofsillim.apimte.contents.mainpage.domain.entity.MosHistory;
import club.menofsillim.apimte.contents.mainpage.repository.MosHistoryRepository;
import club.menofsillim.apimte.contents.mainpage.service.MosHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MosHistoryServiceImpl implements MosHistoryService {

    private final MosHistoryRepository mosHistoryRepository;

    @Override
    public MosHistoryResponse addNewMosHistory(MosHistoryRequest request) {
        return MosHistory.mosHistoryResponse(mosHistoryRepository.save(MosHistory.saveOf(request)));
    }

    @Override
    public List<MosHistoryResponse> findAllMosHistory() {
        List<MosHistory> mosHistories = mosHistoryRepository.findAll();
        return mosHistories.parallelStream()
                .map(MosHistory::mosHistoryResponse)
                .sorted(Comparator.comparingInt(MosHistoryResponse::sort)).toList();
    }
}
