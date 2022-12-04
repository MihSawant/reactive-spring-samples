package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class SchedulersHookTest {

    @Test
    public void onScheduleHook(){
        Schedulers.onScheduleHook("trying-schedule", runnable -> () ->{
           var currentThread = Thread.currentThread().getName();
            System.out.println("ping");
            runnable.run();
        });

       var task_1  = Flux.just("One", "Two").delayElements(Duration.ofMillis(1))
                       .subscribeOn(Schedulers.immediate());

       task_1.subscribe();




    }
}
