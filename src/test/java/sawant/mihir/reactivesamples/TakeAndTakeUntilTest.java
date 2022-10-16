package sawant.mihir.reactivesamples;

import java.util.Map;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class TakeAndTakeUntilTest {
 

    @Test
    public void topFiveTest(){
        
        var ranks = getRanks();
        ranks.take(5);
        
        StepVerifier.create(ranks).expectNext(1, 2, 3, 4, 5);
    }

    @Test
    public void stopAtTen(){
        
        var tenValues = getRanks().takeUntil(i -> i == 10);
        StepVerifier.create(tenValues).expectNextCount(10)
        .verifyComplete();
    }

    private Flux<Integer> getRanks(){
        return Flux.range(1, 10_000_000_0);
    }
}
