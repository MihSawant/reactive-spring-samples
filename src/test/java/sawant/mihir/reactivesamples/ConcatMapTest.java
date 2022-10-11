package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

class Process{
    String name;
    int time;

    public Process(String name, int time){
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

public class ConcatMapTest {

    @Test
    public void orderedTest(){
        var processes = Flux.just(
                new Process("P1", 100),
                new Process("P2", 500),
                new Process("P3", 200),
                new Process("P4", 400)
        ).concatMap(p -> this.delayTime(p.getTime()));

        StepVerifier.create(processes).expectNext(
                100, 500,
                200, 400).verifyComplete();

    }

    public Flux<Integer> delayTime(int time){
       return Flux.just(time).delayElements(Duration.ofNanos(time));
    }
}
