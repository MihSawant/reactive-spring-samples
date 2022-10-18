package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FilterTest {

    @Test
    public void firstTenEven(){
        Flux<Integer> values = Flux.range(1, 101)
                .take(10)
                        .filter(i -> i % 2 ==0);


        StepVerifier.create(values).expectNext(2, 4 ,6, 8, 10)
                .verifyComplete();

    }
}
