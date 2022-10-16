package sawant.mihir.reactivesamples;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class SwitchMapTest {
    
    @Test
    public void wordTest(){
        Flux<String> message = Flux.just("h", "he", "hel", "hell", "hello")
                                    .delayElements(Duration.ofSeconds(1))
                                    .switchMap(w -> this.getWord(w));

        message.toStream().forEach(System.out::println);

        StepVerifier.create(message).expectNext("hello").verifyComplete();
    }


    public Flux<String> getWord(String word){
        return Flux.just(word).delayElements(Duration.ofSeconds(5));
    }
}
