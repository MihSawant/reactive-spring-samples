package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class ThenManyTest {

    @Test
    public void thenManyPublishers(){

        Flux<String> subjects = Flux.just("Java Programming", "DSA", "DBMS", "OS");
        Flux<Integer> codes = Flux.just(1, 2, 3 ,4);

        var subjectsAndCodes = codes.thenMany(subjects);

        subjectsAndCodes.toStream().forEach(System.out::println);


        StepVerifier.create(subjectsAndCodes)
                .expectNext("Java Programming", "DSA", "DBMS", "OS").verifyComplete();
    }
}
