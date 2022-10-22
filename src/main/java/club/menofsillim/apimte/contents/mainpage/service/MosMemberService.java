package club.menofsillim.apimte.contents.mainpage.service;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberSkillInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.MosMemberInfoResponse;

import java.util.List;

public interface MosMemberService {
    MosMemberInfoResponse addToNewMosMember(final MosMemberInfoRequest request);
    List<MosMemberInfoResponse> findAllMosMember();
    MosMemberInfoResponse addToSkillInMosMember(final MosMemberSkillInfoRequest request);
    void deleteMosMember(final Long memberSeq);
    void useMosMember(final Long memberSeq);
}
