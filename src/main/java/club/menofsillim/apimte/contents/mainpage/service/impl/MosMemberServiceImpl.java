package club.menofsillim.apimte.contents.mainpage.service.impl;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberSkillInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.MosMemberInfoResponse;
import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import club.menofsillim.apimte.contents.mainpage.domain.entity.Skill;
import club.menofsillim.apimte.contents.mainpage.domain.mosmember.MosMemberDuplicateException;
import club.menofsillim.apimte.contents.mainpage.domain.mosmember.MosMemberNotFoundExcpetion;
import club.menofsillim.apimte.contents.mainpage.repository.MosMemberRepository;
import club.menofsillim.apimte.contents.mainpage.repository.SkillRepository;
import club.menofsillim.apimte.contents.mainpage.service.MosMemberService;
import club.menofsillim.apimte.global.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MosMemberServiceImpl implements MosMemberService {

    private final MosMemberRepository mosMemberRepository;
    private final SkillRepository skillRepository;

    @Override
    public MosMemberInfoResponse addToNewMosMember(final MosMemberInfoRequest request) {
        this.findExistsMosMember(request);
        MosMember mosMember = mosMemberRepository.save(MosMember.of(request));
        return new MosMemberInfoResponse(mosMember);
    }

    @Override
    public List<MosMemberInfoResponse> findAllMosMember() {
        List<MosMember> mosMembers = mosMemberRepository.findMosMembersByUseYnTrue();
        if (mosMembers.isEmpty()) {
            throw new MosMemberNotFoundExcpetion("Mos member is not exists");
        }
        List<MosMemberInfoResponse> responses = new ArrayList<>();
        mosMembers.forEach(member -> responses.add(new MosMemberInfoResponse(member)));
        return responses;
    }

    @Override
    public MosMemberInfoResponse addToSkillInMosMember(final MosMemberSkillInfoRequest request) {
        MosMember mosMember = mosMemberRepository.findMosMemberByNickNameAndUseYnTrue(request.getNickName());
        if (Objects.isNull(mosMember)) {
            throw new MosMemberNotFoundExcpetion("존재하지 않는 멤버입니다.");
        }
        Skill skill = skillRepository.findSkillBySkillNameAndUseYnTrue(request.getSkillName()).orElseThrow(ResourceNotFoundException::new);
        boolean result = mosMember.getSkills().stream().noneMatch(memberSkill -> memberSkill.getSkillSeq().equals(skill.getSkillSeq()));
        mosMember.getSkills().add(result ? skill : null);

        return new MosMemberInfoResponse(mosMember);
    }

    @Override
    public void deleteMosMember(final Long memberSeq) {
        MosMember mosMember = mosMemberRepository.findMosMemberByMemberSeqAndUseYnTrue(memberSeq).orElseThrow(MosMemberNotFoundExcpetion::new);

        mosMember.deleteOf();
    }

    @Override
    public void useMosMember(final Long memberSeq) {
        MosMember mosMember = mosMemberRepository.findMosMemberByMemberSeqAndUseYnFalse(memberSeq).orElseThrow(MosMemberNotFoundExcpetion::new);

        mosMember.useOf();
    }

    private void findExistsMosMember(final MosMemberInfoRequest request) {
        log.info(">> 사용자 정보 저장 :: [{}]", request);
        MosMember mosMember = mosMemberRepository.findCustomMosMemberByNickname(request.getNickName());
        if (!Objects.isNull(mosMember)) {
            throw new MosMemberDuplicateException("중복된 닉네임입니다.");
        }
    }
}
