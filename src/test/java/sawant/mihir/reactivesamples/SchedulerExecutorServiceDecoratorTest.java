package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.BeforeEach;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ScheduledExecutorService;

public class SchedulerExecutorServiceDecoratorTest {

    @BeforeEach
    public void before(){
        Schedulers.resetFactory();

        Schedulers.addExecutorServiceDecorator("key-1", (scheduler, scheduledExecutorService) -> this.method(scheduledExecutorService));
    }

    public ScheduledExecutorService method(ScheduledExecutorService service){
        service.submit(() ->{
            System.out.println("Hello World");
        });
        service.submit(() ->{
           for(int i = 1; i <= 5; i++){
               System.out.println("Task: "+i);
           }
        });
        return service;
    }
}

