package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.ReplayProcessor;
import reactor.test.StepVerifier;

public class ReplayProcessorTest {

    @Test
    public void replayProcessor(){
        int historySize = 3;
        boolean unbounded = false;

        ReplayProcessor<String> replayProcessor =
                ReplayProcessor.create(historySize, unbounded);

                                        replayProcessor.sink()
                                                    .next("1")
                                                    .next("2")
                                                    .next("3")
                                                    .complete();


            StepVerifier.create(replayProcessor)
                        .expectNext("1")
                        .expectNext("2")
                        .expectNext("3")
                        .verifyComplete();

    }
}
