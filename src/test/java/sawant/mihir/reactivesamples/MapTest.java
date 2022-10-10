package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class MapTest {
    
    @Test
    public void cubeTest(){
        Flux<Integer> nos = Flux.just(1, 2, 3, 4);

        Flux<Double> cubeMap = nos.map(n -> Math.pow(n, 3));

        StepVerifier.create(cubeMap)
                .expectNext(1.0, 8.0, 27.0, 64.0)
                .verifyComplete();
    }
}
