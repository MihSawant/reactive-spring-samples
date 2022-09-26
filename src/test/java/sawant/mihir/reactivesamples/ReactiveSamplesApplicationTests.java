package sawant.mihir.reactivesamples;


import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

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

    @Test
    public void testName(){
      Mono<String> name = Mono.just("Mihir");

      StepVerifier.create(name).expectNext("Mihir").verifyComplete();

    }

    @Test
    public void streamTest(){
        AtomicInteger integer  = new AtomicInteger();

        Supplier<Integer> supplier = integer::incrementAndGet;

        Flux<Integer> values = Flux.fromStream(Stream.generate(supplier));

        // Its basically flux of many values wrapped inside a stream
        StepVerifier.create(values).expectNext(1).expectNext(2)
                .expectNext(3).expectComplete();
    }





}
