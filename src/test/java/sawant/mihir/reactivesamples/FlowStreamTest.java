package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import org.reactivestreams.FlowAdapters;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.concurrent.Flow;

public class FlowStreamTest {

    @Test
    public void convert(){
        Flux<Integer> original = Flux.range(0, 5);
        Flow.Publisher<Integer> integerPublisher = FlowAdapters.toFlowPublisher(original);
        Publisher<Integer> publisher = FlowAdapters.toPublisher(integerPublisher);

        StepVerifier.create(publisher).expectNextCount(5).verifyComplete();
    }
}
