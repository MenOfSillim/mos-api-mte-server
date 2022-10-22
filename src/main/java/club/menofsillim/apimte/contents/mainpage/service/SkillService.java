package club.menofsillim.apimte.contents.mainpage.service;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.SkillInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.SkillInfoResponse;

public interface SkillService {

    SkillInfoResponse addToNewSkill(final SkillInfoRequest request);
}
