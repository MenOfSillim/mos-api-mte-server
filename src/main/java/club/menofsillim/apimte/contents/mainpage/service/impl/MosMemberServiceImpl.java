package club.menofsillim.apimte.contents.mainpage.service.impl;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.MosMemberInfoResponse;
import club.menofsillim.apimte.contents.mainpage.domain.entity.MosMember;
import club.menofsillim.apimte.contents.mainpage.domain.mosmember.MosMemberDuplicateException;
import club.menofsillim.apimte.contents.mainpage.domain.mosmember.MosMemberNotFoundExcpetion;
import club.menofsillim.apimte.contents.mainpage.repository.MosMemberRepository;
import club.menofsillim.apimte.contents.mainpage.repository.SkillRepository;
import club.menofsillim.apimte.contents.mainpage.service.MosMemberService;
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
        List<MosMember> mosMembers = mosMemberRepository.findAll();
        if (mosMembers.isEmpty()) {
            throw new MosMemberNotFoundExcpetion("Mos member is not exists");
        }
        List<MosMemberInfoResponse> responses = new ArrayList<>();
        mosMembers.forEach(member -> responses.add(new MosMemberInfoResponse(member)));
        return responses;
    }

    private void findExistsMosMember(final MosMemberInfoRequest request) {
        log.info(">> 사용자 정보 저장 :: [{}]", request);
        MosMember mosMember = mosMemberRepository.findMosMemberByNickName(request.getNickName());
        if (!Objects.isNull(mosMember)) {
            throw new MosMemberDuplicateException("중복된 닉네임입니다.");
        }
    }
}
