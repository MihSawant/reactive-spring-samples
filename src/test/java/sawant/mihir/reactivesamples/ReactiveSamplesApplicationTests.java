package sawant.mihir.reactivesamples;


import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class ReactiveSamplesApplicationTests {

    @Test
    public void fluxTest(){

//        Flux<Integer> range = Flux.range(1, 5);

        // It is just a publisher, Flux which contain 5 values in range 1 - 5
        Publisher<Integer> range = Flux.range(1, 5);



        StepVerifier.create(range).expectNextCount(5).verifyComplete();
    }

    @Test
    public void testLetters(){
        // Create flux of three strings and verify them

        Flux<String> letters = Flux.just("A", "B", "C");

        StepVerifier.create(letters).expectNext("A", "B", "C").verifyComplete();
    }



}
