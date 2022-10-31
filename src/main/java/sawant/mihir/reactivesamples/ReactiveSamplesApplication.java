package sawant.mihir.reactivesamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sawant.mihir.reactivesamples.webclient.BasicWebClient;

@SpringBootApplication
public class ReactiveSamplesApplication {

    public static void main(String[] args) {

        SpringApplication.run(ReactiveSamplesApplication.class, args);
    }

}
