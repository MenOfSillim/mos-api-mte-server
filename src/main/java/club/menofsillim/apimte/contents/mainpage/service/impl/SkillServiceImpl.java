package club.menofsillim.apimte.contents.mainpage.service.impl;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.SkillInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.SkillInfoResponse;
import club.menofsillim.apimte.contents.mainpage.domain.entity.Skill;
import club.menofsillim.apimte.contents.mainpage.domain.skill.SkillInfoDuplicateException;
import club.menofsillim.apimte.contents.mainpage.repository.SkillRepository;
import club.menofsillim.apimte.contents.mainpage.service.SkillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public SkillInfoResponse addToNewSkill(SkillInfoRequest request) {
        this.findExistsSkill(request);
        Skill skill = skillRepository.save(Skill.saveOf(request));
        return new SkillInfoResponse(skill);
    }

    private void findExistsSkill(final SkillInfoRequest request) {
        log.info(">> 기술 정보 저장 :: [{}]", request);
        Skill existsSkill = skillRepository.findSkillBySkillName(request.getSkillName());
        if (!Objects.isNull(existsSkill)) {
            throw new SkillInfoDuplicateException("이미 존재하는 기술입니다.");
        }
    }
}
