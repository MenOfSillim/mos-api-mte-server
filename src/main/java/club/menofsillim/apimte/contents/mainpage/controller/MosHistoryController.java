package club.menofsillim.apimte.contents.mainpage.controller;

import club.menofsillim.apimte.contents.mainpage.domain.dto.request.MosHistoryRequest;
import club.menofsillim.apimte.contents.mainpage.domain.dto.response.MosHistoryResponse;
import club.menofsillim.apimte.contents.mainpage.service.MosHistoryService;
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

@Slf4j
@RestController("/v1/history")
@RequiredArgsConstructor
public class MosHistoryController {

    private final MosHistoryService mosHistoryService;

    @Operation(summary = "Save new MOS History", description = "새로운 MOS 역사")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/mos-histories")
    public ResponseEntity<?> addToNewMosHistory(@Validated @ApiParam final MosHistoryRequest request, BindingResult bindingResult) {
        log.info(">> addToNewMosHistory request data :: [{}]", request);
        if (bindingResult.hasErrors()) {
            final List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(new ErrorResponse("400", "Validation Failure", errors));
        }
        return ResponseEntity.ok(mosHistoryService.addNewMosHistory(request));
    }

    @Operation(summary = "Fins all MOS History", description = "모든 MOS 역사")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/mos-histories")
    public ResponseEntity<List<MosHistoryResponse>> findAllMosHistory() {
        return ResponseEntity.ok(mosHistoryService.findAllMosHistory());
    }
}
