package club.menofsillim.apimte.member.controller;

import club.menofsillim.apimte.common.ErrorResponse;
import club.menofsillim.apimte.member.domain.dto.MemberDTO;
import club.menofsillim.apimte.member.domain.entity.Member;
import club.menofsillim.apimte.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "Select all members", description = "모든 멤버 조회")
    @ApiResponse(responseCode = "200", description = "Success")
//    @ApiResponse(responseCode = "400", description = "Bad Request")
//    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/members")
    public ResponseEntity<List<Member>> members() {
        return ResponseEntity.ok(memberService.members());
    }

    @Operation(summary = "Save new member", description = "새로운 멤버 추가")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Validation Failure")
//    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/member")
    public ResponseEntity<?> saveMember(@Validated @RequestBody final MemberDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(new ErrorResponse("400", "Validation Failure", errors));
        }
        return ResponseEntity.ok(memberService.saveMember(dto.toEntity()));
    }
}
