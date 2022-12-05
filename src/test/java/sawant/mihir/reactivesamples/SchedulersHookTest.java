package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

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

        StepVerifier.create(task_1).expectNextCount(2).verifyComplete();
    }

    @Test
    public void onScheduleWithError(){
        Schedulers.onSchedule(()->{
            for(int counter = 1;  counter <= 5; counter++){
                System.out.println("Count = "+counter);
            }
        }).run();

        var errorObj = new RuntimeException("Something went wrong");

        var errorPipeline = Flux.just("Pipe_1", "Pipe_2", "Pipe_3",
                        errorObj)
                .delayElements(Duration.ofNanos(1))
                .doOnError((error)-> System.out.println(error.getMessage()))
                .subscribeOn(Schedulers.immediate());


        errorPipeline.subscribe();

        StepVerifier.create(errorPipeline)
                .expectNext("Pipe_1")
                .expectNext("Pipe_2")
                .expectNext("Pipe_3")
                .expectNext(errorObj)
                .verifyComplete();
    }
}
