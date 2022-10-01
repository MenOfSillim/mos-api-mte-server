package club.menofsillim.apimte.contents.member.service;

import club.menofsillim.apimte.contents.member.domain.entity.Member;
import club.menofsillim.apimte.contents.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public List<Member> members() {
        return memberRepository.findAll();
    }

    @Override
    public Member saveMember(final Member member) {
        return memberRepository.save(member);
    }
}

