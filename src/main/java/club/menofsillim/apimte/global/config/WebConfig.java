package club.menofsillim.apimte.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String BASE_URL = "http://192.168.0.16:30040";
    private static final String KELLOGG_VPN_URL = "http://192.168.0.204:3000";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(BASE_URL, KELLOGG_VPN_URL)
                .allowedMethods("*")
                .maxAge(3000);
    }
}
