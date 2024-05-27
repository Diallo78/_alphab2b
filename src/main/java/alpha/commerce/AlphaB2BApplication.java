package alpha.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AlphaB2BApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaB2BApplication.class, args);
    }

}
