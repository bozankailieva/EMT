package finki.mk.emt_lab_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EmtLab1Application {
    public static void main(String[] args) {
        SpringApplication.run(EmtLab1Application.class, args);
    }
}
