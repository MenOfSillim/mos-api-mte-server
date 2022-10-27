package club.menofsillim.apimte.contents.mainpage.controller;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberSkillInfoRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.MosMemberInfoResponse;
import club.menofsillim.apimte.contents.mainpage.service.MosMemberService;
import club.menofsillim.apimte.global.common.ErrorResponse;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController("/v1/member")
@RequiredArgsConstructor
public class MosMemberController {

    private final MosMemberService memberService;

    @Operation(summary = "Save new MOS member", description = "새로운 MOS 멤버 추가")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/mos-members")
    public ResponseEntity<?> addToNewMosMember(@Validated @ApiParam final MosMemberInfoRequest request, BindingResult bindingResult) {
        log.info(">> addToNewMosMember request data :: [{}]", request);
        if (bindingResult.hasErrors()) {
            final List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(new ErrorResponse("400", "Validation Failure", errors));
        }
        return ResponseEntity.ok(memberService.addToNewMosMember(request));
    }

    @Operation(summary = "Find All MOS member", description = "모든 MOS 멤버 찾기")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/mos-members")
    public ResponseEntity<List<MosMemberInfoResponse>> findAllMosMember() {
        return ResponseEntity.ok(memberService.findAllMosMember());
    }

    @Operation(summary = "MOS member link skill", description = "MOS 멤버 기술 엮기")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/mos-members/skill")
    public ResponseEntity<?> addToSkillInMosMember(@Validated @ApiParam final MosMemberSkillInfoRequest request, BindingResult bindingResult) {
        log.info(">> addTOSkillInMosMember request data :: [{}]", request);
        if (bindingResult.hasErrors()) {
            final List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(new ErrorResponse("400", "Unsatisfied Parameter", errors));
        }
        return ResponseEntity.ok(memberService.addToSkillInMosMember(request));
    }

    @Operation(summary = "MOS member no use", description = "MOS 멤버 지우기")
    @DeleteMapping("/mos-members")
    public void deleteMosMember(@ApiParam @RequestParam final Long memberSeq) {
        memberService.deleteMosMember(memberSeq);
    }

    @Operation(summary = "MOS member use", description = "MOS 멤버 되돌리기")
    @PatchMapping("/mos-members")
    public void useMosMember(@ApiParam @RequestParam final Long memberSeq) {
        memberService.useMosMember(memberSeq);
    }
}
