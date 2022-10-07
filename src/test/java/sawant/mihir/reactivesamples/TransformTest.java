package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Locale;

public class TransformTest {

    @Test
    public void transformingPublisherTest(){
        Flux<String> names = Flux.just("yash", "hari",
                "aayan", "azirel", "suresh","shayan");
        names.transform(
                nameList -> names.doOnEach(name -> name.get().toUpperCase(Locale.ROOT)));

        StepVerifier.create(names)
                .expectNext("YASH").expectNext("HARI")
                .expectNext("AAYAN").expectNext("AZIREL")
                .expectNext("SURESH").expectNext("SHAYAN");

    }
}
