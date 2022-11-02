package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;

public class SchedulerExecutorServiceDecoratorTest {

    @BeforeEach
    public void before(){
        Schedulers.resetFactory();

        Schedulers.addExecutorServiceDecorator("key-1",
                (scheduler, scheduledExecutorService) ->
                        this.decorateMethod(scheduledExecutorService));
    }


    public ScheduledExecutorService decorateMethod(ScheduledExecutorService service){
        service.execute(()->{
            System.out.println("Hello World");
        });
        return service;
    }

    @Test
    public void sampleTest(){

    }


}

