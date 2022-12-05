package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SchedulerCustomExecutor {

    @Test
    public void customExecutor(){
        ExecutorService customExecThread = Executors.newFixedThreadPool(3, runnable -> {
            var currThread = Thread.currentThread().getName();
            System.out.println(currThread);
            return new Thread(runnable, "CustomExecThread");
        });

        Scheduler myScheduler = Schedulers.fromExecutor(customExecThread);

        var testPublisher = Mono.just(new Object())
                .doOnNext(o -> Assertions.assertEquals("CustomExecThread", Thread.currentThread().getName()))
                .subscribeOn(myScheduler);

        StepVerifier.create(testPublisher).expectNextCount(1)
                .verifyComplete();


    }
}
