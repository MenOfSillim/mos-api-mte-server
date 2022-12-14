package club.menofsillim.apimte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MamtesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MamtesApplication.class, args);
    }

}
