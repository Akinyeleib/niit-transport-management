package competition.transport.config;

import competition.transport.utils.Utils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Utils util() {
        return new Utils();
    }
}
