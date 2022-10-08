package club.menofsillim.apimte.contents.mainpage.controller;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosMemberInfoRequest;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
