package club.menofsillim.apimte.contents.contact;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/login")
    public Mono<String> doLogin() {
        WebClient client = WebClient.create();
        return client.get()
                .uri("http://localhost:8081/manager/path1")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/test")
    public Mono<String> doTest() {
        WebClient client = WebClient.create();
        return client.get()
                .uri("http://localhost:8081/")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/auth/login")
    public Mono<String> doAuthLogin() {
        WebClient client = WebClient.create();
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("localhost:8081/auth/login")
                        .queryParam("path", "localhost:8082/callback/login")
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/callback")
    public String afterLogin(HttpServletResponse response, HttpServletRequest request) {
        log.info(">> get keycloak access token {{}}", response.getHeader("keycloak-access-token"));
        log.info("{{}}", request);
        return "LOGIN SUCCESS!!";
    }

    @GetMapping("/auth/login2")
    public void daAuthLogin2(HttpServletResponse response) {
        log.info(">> /auth/login2 !!");
        try {
            response.sendRedirect("http://localhost:8081/auth/login/callback");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
