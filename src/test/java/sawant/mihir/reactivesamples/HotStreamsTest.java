package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.FluxSink;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HotStreamsTest {

    @Test
    public void testHotStream(){
        List<String> stocks = new ArrayList<>();

        Consumer<String> events =  s -> stocks.add(s);

        List<String> firstSubscriber = new ArrayList<>();
        List<String> secondSubsciber = new ArrayList<>();

        EmitterProcessor<String> eventEmitter = EmitterProcessor.create(5);
        FluxSink<String> fluxSink = eventEmitter.sink();
        fluxSink.next("Nifty_50");
        fluxSink.next("Sensex");
        fluxSink.next("Bank_NIFTY");
        fluxSink.next("NIFTY_MIDCAP SELECT");
        fluxSink.next("NIFTY_FINANCIAL Services");

        // Subscriber 1 subscribes to first 3 events
        eventEmitter.subscribe(collect(firstSubscriber));
        eventEmitter.sink();
        eventEmitter.sink();
        eventEmitter.sink();

        // next subscriber only 2 events which are remaining
        eventEmitter.subscribe(collect(secondSubsciber));
        eventEmitter.sink();
        eventEmitter.sink();

        Assert.isTrue(firstSubscriber.size() > secondSubsciber.size());

    }

    public Consumer<String> collect(List<String> data){
        return data::add;
    }
}
