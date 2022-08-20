package club.menofsillim.apimte.member.service;

import club.menofsillim.apimte.member.domain.entity.Member;
import club.menofsillim.apimte.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public List<Member> members() {
        if (!this.findTempMember()) {
            this.saveTempMember();
        }
        return memberRepository.findAll();
    }

    private void saveTempMember() {
        Member member = Member.builder()
                .name("Gyuhwan")
                .age(32)
                .build();
        memberRepository.save(member);
    }

    private boolean findTempMember() {
        Optional<Member> memberOptional = Optional.ofNullable(memberRepository.findMemberByName("Gyuhwan"));
        return memberOptional.isPresent();
    }
}
