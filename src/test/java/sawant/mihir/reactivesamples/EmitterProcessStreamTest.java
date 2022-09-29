package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.test.StepVerifier;

public class EmitterProcessStreamTest {

    @Test
    public void emitterTest(){
        EmitterProcessor<String>  queue = EmitterProcessor.create();
        produce(queue.sink());
        consume(queue);
    }

    private void produce(FluxSink<String> sink){
        sink.next("1");
        sink.next("2");
        sink.next("3");
        sink.next("4");
        sink.complete();
    }

    private void consume(Flux<String> publisher){
        StepVerifier.create(publisher)
                .expectNext("1")
                .expectNext("2")
                .expectNext("3")
                .expectNext("4")
                .verifyComplete();
    }
}
