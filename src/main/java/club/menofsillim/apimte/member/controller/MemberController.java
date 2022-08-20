package club.menofsillim.apimte.member.controller;

import club.menofsillim.apimte.member.domain.entity.Member;
import club.menofsillim.apimte.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public List<Member> members() {
        return memberService.members();
    }
}
